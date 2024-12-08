package cn.edu.nwafu.cie.teach.common.constant;

import cn.edu.nwafu.cie.teach.common.api.IErrorCode;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * API 操作码。
 *
 * @author Huang Z.Y.
 * @create 2024-12-09 00:12
 */
@AllArgsConstructor
@Getter
public enum ResultCode implements IErrorCode {
    SUCCESS(200, "操作成功"),
    FAILED(500, "操作失败"),
    VALIDATE_FAILED(404, "参数检验失败"),
    UNAUTHORIZED(401, "暂未登录或token已经过期"),
    FORBIDDEN(403, "没有相关权限");

    private int code;
    private String message;
}
    