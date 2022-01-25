package cn.oldensheepdog.testannotation.service;

import redis.clients.jedis.Jedis;

public interface RedisService {

    Jedis getResource();

    void returnResource(Jedis jedis);

    boolean tryGetDistributedLock(String lockKey, String requestId, Integer expireTime);

    boolean releaseDistributeLock(String lockKey, String requestId);

}
