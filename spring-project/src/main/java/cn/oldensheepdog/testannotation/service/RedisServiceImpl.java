package cn.oldensheepdog.testannotation.service;

import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.util.Collections;

@Service(value = "redisService")
public class RedisServiceImpl implements RedisService{

    private static final String LOCK_SUCCESS = "OK";
    private static final String SET_IF_NOT_EXIST = "NX";
    private static final String SET_WITH_EXPIRE_TIME="PX";
    private static final int EXPIRE_TIMEOUT = 180000;
    private static final Long RELEASE_SUCCESS = 1L;

    private final JedisPool jedisPool;

    public RedisServiceImpl(JedisPool jedisPool) {
        this.jedisPool = jedisPool;
    }

    @Override
    public Jedis getResource() {
        return jedisPool.getResource();
    }

    @Override
    public void returnResource(Jedis jedis) {
        if (jedis != null){
            jedisPool.returnResource(jedis);
        }
    }

    @Override
    public boolean tryGetDistributedLock(String lockKey, String requestId, Integer expireTime) {
        Jedis jedis = getResource();
        String result = jedis.set(lockKey, requestId);
        returnResource(jedis);
        return LOCK_SUCCESS.equals(result);
    }

    @Override
    public boolean releaseDistributeLock(String lockKey, String requestId) {
        Jedis jedis = getResource();
        String script = "if redis.call('get',KEYS[1])==ARGV[1] then return redis.call('del',KEYS[1]) else return 0 end";
        Object result = jedis.eval(script, Collections.singletonList(lockKey), Collections.singletonList(requestId));
        returnResource(jedis);
        return RELEASE_SUCCESS.equals(result);
    }
}
