package cn.edu.nwafu.cie.teach.common.log.util;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * 日志类型。
 *
 * @author Huang Z.Y.
 * @create 2024-11-25 00:12
 */
@Getter
@RequiredArgsConstructor
public enum LogTypeEnum {
    /**
     * 正常日志类型
     */
    NORMAL(0, "正常日志"),

    /**
     * 错误日志类型
     */
    ERROR(9, "错误日志");

    /**
     * 日志类型
     */
    private final Integer type;

    /**
     * 描述
     */
    private final String description;
}
    