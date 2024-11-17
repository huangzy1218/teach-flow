package cn.edu.nwafu.cie.teach.common.util;

import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.script.DefaultRedisScript;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * Redis 分布式锁。
 *
 * @author Huang Z.Y.
 * @create 2024-11-17 23:20
 */
@Component
public class RedisDistributedLock {
    private final StringRedisTemplate redisTemplate;
    private final ThreadLocal<String> lockValue = new ThreadLocal<>();

    public RedisDistributedLock(StringRedisTemplate redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    public boolean tryLock(String key, long expire, TimeUnit timeUnit) {
        String value = UUID.randomUUID().toString();
        Boolean success = redisTemplate.opsForValue().setIfAbsent(key, value, expire, timeUnit);
        if (Boolean.TRUE.equals(success)) {
            lockValue.set(value);
            return true;
        }
        return false;
    }

    public boolean releaseLock(String key) {
        String value = lockValue.get();
        if (value == null) {
            return false;
        }
        DefaultRedisScript<Boolean> script =
                new DefaultRedisScript<>(
                        "if redis.call('get', KEYS[1]) == ARGV[1] then return redis.call('del',"
                                + " KEYS[1]) else return 0 end",
                        Boolean.class);
        Boolean success = redisTemplate.execute(script, Collections.singletonList(key), value);
        if (Boolean.TRUE.equals(success)) {
            lockValue.remove();
            return true;
        }
        return false;
    }
}
    