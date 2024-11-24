package cn.edu.nwafu.cie.teach.common.aspect;

import cn.edu.nwafu.cie.teach.common.annotation.Lock;
import cn.edu.nwafu.cie.teach.common.exception.LimitException;
import cn.edu.nwafu.cie.teach.common.util.RedisDistributedLock;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

/**
 * Redis 锁注解切面。
 *
 * @author Huang Z.Y.
 * @create 2024-11-17 23:19
 */
@Aspect
@Component
public class LockAspect {
    private final RedisDistributedLock redisDistributedLock;

    public LockAspect(RedisDistributedLock redisDistributedLock) {
        this.redisDistributedLock = redisDistributedLock;
    }

    @Around("@annotation(cn.edu.nwafu.cie.teach.common.annotation.Lock)")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        Lock distributedLock = method.getAnnotation(Lock.class);
        String key = distributedLock.key();
        long expire = distributedLock.expire();
        TimeUnit timeUnit = distributedLock.timeUnit();
        boolean success = redisDistributedLock.tryLock(key, expire, timeUnit);
        if (!success) {
            throw new LimitException("请稍后再试");
        }
        try {
            return joinPoint.proceed();
        } finally {
            redisDistributedLock.releaseLock(key);
        }
    }
}
    