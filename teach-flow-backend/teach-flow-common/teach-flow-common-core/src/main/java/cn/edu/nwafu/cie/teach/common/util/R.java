package cn.edu.nwafu.cie.teach.common.util;

import cn.edu.nwafu.cie.teach.common.constant.CommonConstants;
import lombok.*;
import lombok.experimental.Accessors;

import java.io.Serial;
import java.io.Serializable;

/**
 * 响应体实体类。
 *
 * @author Huang Z.Y.
 * @create 2024-11-25 01:31
 */
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class R implements Serializable {
    @Serial
    private static final long serialVersionUID = -3446787679926414622L;

    @Getter
    @Setter
    private int code;

    @Getter
    @Setter
    private String msg;

    @Getter
    @Setter
    private Object data;

    public static R success() {
        return restResult(null, CommonConstants.SUCCESS, null);
    }

    public static R success(Object data) {
        return restResult(data, CommonConstants.SUCCESS, null);
    }

    public static R success(Object data, String msg) {
        return restResult(data, CommonConstants.SUCCESS, msg);
    }

    public static R failed() {
        return restResult(null, CommonConstants.FAIL, null);
    }

    public static R failed(String msg) {
        return restResult(null, CommonConstants.FAIL, msg);
    }

    public static R failed(Object data) {
        return restResult(data, CommonConstants.FAIL, null);
    }

    public static R failed(Object data, String msg) {
        return restResult(data, CommonConstants.FAIL, msg);
    }

    public static R restResult(Object data, int code, String msg) {
        R apiResult = new R();
        apiResult.setCode(code);
        apiResult.setData(data);
        apiResult.setMsg(msg);
        return apiResult;
    }
}
    