package cn.oldensheepdog.testannotation.aop;

import cn.oldensheepdog.testannotation.annotation.GetDistributedLock;
import cn.oldensheepdog.testannotation.service.RedisService;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

/**
 * https://segmentfault.com/a/1190000038172702 参考地址
 * */

@Component
@Aspect
@Slf4j
public class DistributedLockAspect {
    private final RedisService redisService;

    public DistributedLockAspect(RedisService redisService) {
        this.redisService = redisService;
    }

    /**
     * 动态代理在java中最常见的应用之一就是切面编程
     *
     * Around 环绕增强通知
     * joinPoint 连接点，所有方法都属于连接点；但是当某些方法上使用了@GetDistributedLock自定义注解时，
     * 则其将连接点变为了切点；然后在切点上织入额外的增强处理；切点和其相应的增强处理构成了切面Aspect
     * */

    @Around(value = "@annotation(cn.oldensheepdog.testannotation.annotation.GetDistributedLock)")
    public Boolean handlerDistributedLock(ProceedingJoinPoint joinPoint){
        // 通过反射获取自定义注解类
        GetDistributedLock getDistributedLock = ((MethodSignature)joinPoint.getSignature()).getMethod().getAnnotation(GetDistributedLock.class);

        // 获取自定义注解对象中的属性值
        String lockKey = getDistributedLock.lockKey();
        String lockValue = getDistributedLock.lockValue();
        int expireTime = getDistributedLock.expireTime();

        if (redisService.tryGetDistributedLock(lockKey, lockValue, expireTime)) {
            //获取分布式锁成功后，继续执行业务逻辑
            try{
                return (boolean)joinPoint.proceed();
            } catch (Throwable throwable){
                log.error("业务逻辑执行失败。 ",throwable);
            } finally {
                //最终保证分布式锁释放
                redisService.releaseDistributeLock(lockKey,lockValue);
            }
        }
        return false;
    }
}
