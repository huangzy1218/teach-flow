package cn.edu.nwafu.cie.teach.common.constant;

/**
 * 系统常量。
 *
 * @author Huang Z.Y.
 * @create 2024-11-19 01:23
 */
public interface CommonConstants {
    String REDIS_PREFIX = "teach-flow:";
    /**
     * 成功标记
     */
    Integer SUCCESS = 0;

    /**
     * 失败标记
     */
    Integer FAIL = 1;

    /**
     * 请求开始时间
     */
    String REQUEST_START_TIME = "REQUEST-START-TIME";
}
    