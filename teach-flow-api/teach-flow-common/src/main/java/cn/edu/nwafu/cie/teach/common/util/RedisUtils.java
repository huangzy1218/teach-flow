package cn.edu.nwafu.cie.teach.common.util;

import cn.edu.nwafu.cie.teach.common.constant.SystemConstants;
import org.springframework.data.redis.core.RedisTemplate;

/**
 * Redis 工具类，用于简化 {@link org.springframework.data.redis.core.RedisTemplate} 的操作。
 *
 * @author Huang Z.Y.
 * @create 2024-11-19 01:16
 */
public class RedisUtils {
    private static RedisTemplate<String, Object> redisTemplate;
    private static final String redisPrefix = SystemConstants.REDIS_PREFIX;


}
    