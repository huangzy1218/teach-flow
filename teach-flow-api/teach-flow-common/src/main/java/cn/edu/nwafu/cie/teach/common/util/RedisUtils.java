package cn.edu.nwafu.cie.teach.common.util;

import cn.edu.nwafu.cie.teach.common.constant.SystemConstants;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.Map;
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

    /**
     * 获取key中 field 域的值
     *
     * @param key   键 不能为null
     * @param field 项 不能为null
     * @return 值
     */
    public static Object hGet(String key, String field) {
        key = redisPrefix + key;
        return redisTemplate.opsForHash().get(key, field);
    }

    /**
     * 判断key中有没有 field 域名
     *
     * @param key   键
     * @param field 字段
     * @return Boolean
     */
    public static Boolean hExists(String key, Object field) {
        key = redisPrefix + key;
        return redisTemplate.opsForHash().hasKey(key, field);
    }

    /**
     * 获取 hashKey 对应的所有键值
     *
     * @param key 键
     * @return 对应的多个键值
     */
    public Map<Object, Object> hmGet(String key) {
        key = redisPrefix + key;
        return redisTemplate.opsForHash().entries(key);
    }

    /**
     * 设置 field1->N 个域,对应的值是 value1->N
     *
     * @param key 键
     * @param map 对应多个键值
     */
    public static void hmSet(String key, Map<String, Object> map) {
        key = redisPrefix + key;
        redisTemplate.opsForHash().putAll(key, map);
    }

    /**
     * HashSet 并设置时间
     *
     * @param key  键
     * @param map  对应多个键值
     * @param time 时间(秒)
     */
    public static void hmSet(String key, Map<String, Object> map, long time) {
        key = redisPrefix + key;
        redisTemplate.opsForHash().putAll(key, map);
        if (time > 0) {
            expire(key, time);
        }
    }

    /**
     * 向一张 hash 表中放入数据，如果不存在将创建
     *
     * @param key   键
     * @param item  项
     * @param value 值
     */
    public static void hSet(String key, String item, Object value) {
        key = redisPrefix + key;
        redisTemplate.opsForHash().put(key, item, value);
    }

    /**
     * 向一张 hash 表中放入数据，如果不存在将创建
     *
     * @param key   键
     * @param item  项
     * @param value 值
     * @param time  时间(秒) 注意:如果已存在的hash表有时间,这里将会替换原有的时间
     * @return true 成功 false失败
     */
    public static boolean hSet(String key, String item, Object value, long time) {
        key = redisPrefix + key;
        redisTemplate.opsForHash().put(key, item, value);
        if (time > 0) {
            expire(key, time);
        }
        return true;
    }

    /**
     * 删除 hash 表中的值
     *
     * @param key  键 不能为 null
     * @param item 项 可以使多个不能为 null
     */
    public static void hDel(String key, Object... item) {
        key = redisPrefix + key;
        redisTemplate.opsForHash().delete(key, item);
    }

    /**
     * 判断 hash 表中是否有该项的值
     *
     * @param key  键 不能为 null
     * @param item 项 不能为 null
     * @return true 存在 false 不存在
     */
    public static boolean hHasKey(String key, String item) {
        key = redisPrefix + key;
        return redisTemplate.opsForHash().hasKey(key, item);
    }

    /**
     * hash 递增。如果不存在，就会创建一个并把新增后的值返回
     *
     * @param key  键
     * @param item 项
     * @param by   要增加几(大于0)
     * @return double
     */
    public static double hIncr(String key, String item, long by) {
        key = redisPrefix + key;
        return redisTemplate.opsForHash().increment(key, item, by);
    }

    /**
     * hash 递减
     *
     * @param key  键
     * @param item 项
     * @param by   要减少记(小于0)
     * @return double
     */
    public static double hDecr(String key, String item, long by) {
        key = redisPrefix + key;
        return redisTemplate.opsForHash().increment(key, item, -by);
    }

    /**
     * 指定缓存失效时间
     *
     * @param key    键
     * @param second 时间(秒)
     */
    public static void expire(String key, Long second) {
        key = redisPrefix + key;
        redisTemplate.expire(key, second, TimeUnit.SECONDS);
    }

    /* ***************** Map end *************** */
}
    