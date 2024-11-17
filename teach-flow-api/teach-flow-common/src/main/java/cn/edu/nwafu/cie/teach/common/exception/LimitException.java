package cn.edu.nwafu.cie.teach.common.exception;

/**
 * 自定义异常类，用于表示特定的限流异常。
 *
 * @author Huang Z.Y.
 * @create 2024-11-17 23:35
 */
public class LimitException extends Exception {
    public LimitException() {
    }

    public LimitException(String message) {
        super(message);
    }

    public LimitException(String message, Throwable cause) {
        super(message, cause);
    }

    public LimitException(Throwable cause) {
        super(cause);
    }

    public LimitException(
            String message,
            Throwable cause,
            boolean enableSuppression,
            boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
    