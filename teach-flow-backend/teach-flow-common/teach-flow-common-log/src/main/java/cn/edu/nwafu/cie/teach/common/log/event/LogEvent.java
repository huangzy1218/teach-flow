package cn.edu.nwafu.cie.teach.common.log.event;

import cn.edu.nwafu.cie.teach.common.log.annotation.Log;
import org.springframework.context.ApplicationEvent;

/**
 * 日志事件。
 *
 * @author Huang Z.Y.
 * @create 2024-11-25 00:07
 */
public class LogEvent extends ApplicationEvent {
    public LogEvent(Log source) {
        super(source);
    }
}
    