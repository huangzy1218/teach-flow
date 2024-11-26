package cn.edu.nwafu.cie.teach.common.log.event;

import cn.edu.nwafu.cie.teach.user.api.domain.SysLog;
import lombok.Data;
import lombok.ToString;

import java.io.Serial;

/**
 * 日志事件来源。
 *
 * @author Huang Z.Y.
 * @create 2024-11-25 00:09
 */
@Data
@ToString(callSuper = true)
public class LogEventSource extends SysLog {
    @Serial
    private static final long serialVersionUID = -2337186429329683325L;
    /**
     * 参数重写成 object
     */
    private Object body;
}
    