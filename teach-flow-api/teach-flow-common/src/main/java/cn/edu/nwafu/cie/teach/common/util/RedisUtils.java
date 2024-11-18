package cn.edu.nwafu.cie.teach.common.util;

import cn.edu.nwafu.cie.teach.common.constant.SystemConstants;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.concurrent.TimeUnit;

/**
 * Redis 工具类，用于简化 {@link org.springframework.data.redis.core.RedisTemplate} 的操作。
 *
 * @author Huang Z.Y.
 * @create 2024-11-19 01:16
 */
public class RedisUtils {
    private static RedisTemplate<String, Object> redisTemplate;
    private static final String redisPrefix = SystemConstants.REDIS_PREFIX;

    /**
     * 获取 key 的值
     *
     * @param key 键
     * @return Object
     */
    public static Object get(String key) {
        key = redisPrefix + key;
        return redisTemplate.opsForValue().get(key);
    }

    /**
     * 获取旧值并设置新值
     *
     * @param key    键
     * @param newVal 新值
     * @return Object
     */
    public static Object getSet(String key, Object newVal) {
        key = redisPrefix + key;
        return redisTemplate.opsForValue().getAndSet(key, newVal);
    }

    /**
     * 设置键值对
     *
     * @param key   键
     * @param value 值
     */
    public static void set(String key, Object value) {
        key = redisPrefix + key;
        redisTemplate.opsForValue().set(key, value);
    }

    /**
     * 设置键值对并设置时间
     *
     * @param key   键
     * @param value 值
     * @param time  time要大于0 如果time小于等于0 将设置无限期
     */
    public static void set(String key, Object value, long time) {
        key = redisPrefix + key;
        if (time > 0) {
            redisTemplate.opsForValue().set(key, value, time, TimeUnit.SECONDS);
        } else {
            set(key, value);
        }
    }

    /**
     * 递增
     *
     * @param key   键
     * @param delta 要增加几(大于0)
     * @return Long
     */
    public static Long incr(String key, long delta) {
        if (delta < 0) {
            throw new RuntimeException("递增因子必须大于0");
        }
        key = redisPrefix + key;
        return redisTemplate.opsForValue().increment(key, delta);
    }

    /**
     * 递减
     *
     * @param key   键
     * @param delta 要减少几(小于0)
     * @return Long
     */
    public static Long decr(String key, long delta) {
        if (delta < 0) {
            throw new RuntimeException("递减因子必须大于0");
        }
        key = redisPrefix + key;
        return redisTemplate.opsForValue().increment(key, -delta);
    }

    /* ***************** String end *************** */
}
    