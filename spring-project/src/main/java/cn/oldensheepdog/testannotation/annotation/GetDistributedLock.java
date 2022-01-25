package cn.oldensheepdog.testannotation.annotation;

import java.lang.annotation.*;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface GetDistributedLock {

    // 分布式锁 key
    String lockKey();

    // 分布式锁 value
    String lockValue() default "lockValue";

    // 过期时间
    int expireTime() default 3;
}
