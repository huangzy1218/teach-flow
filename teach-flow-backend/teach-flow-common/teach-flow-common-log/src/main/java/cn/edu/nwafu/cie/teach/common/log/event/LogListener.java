package cn.edu.nwafu.cie.teach.common.log.event;

import cn.hutool.core.util.StrUtil;
import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import lombok.SneakyThrows;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.event.EventListener;
import org.springframework.core.annotation.Order;
import org.springframework.scheduling.annotation.Async;

import java.util.Objects;

/**
 * 异步监听日志事件。
 *
 * @author Huang Z.Y.
 * @create 2024-11-25 00:10
 */
public class LogListener implements InitializingBean {
    // new 一个 避免日志脱敏策略影响全局ObjectMapper
    private final static ObjectMapper objectMapper = new ObjectMapper();

    private final RemoteLogService remoteLogService;

    private final LogProperties logProperties;

    @SneakyThrows
    @Async
    @Order
    @EventListener(LogEvent.class)
    public void saveSysLog(LogEvent event) {
        LogEventSource source = (LogEventSource) event.getSource();
        LogEventSource sysLog = new LogEventSource();
        BeanUtils.copyProperties(source, sysLog);

        // json 格式刷参数放在异步中处理，提升性能
        if (Objects.nonNull(source.getBody())) {
            String params = objectMapper.writeValueAsString(source.getBody());
            sysLog.setParams(StrUtil.subPre(params, logProperties.getMaxLength()));
        }

        remoteLogService.saveLog(sysLog, SecurityConstants.FROM_IN);
    }

    @Override
    public void afterPropertiesSet() {
        objectMapper.addMixIn(Object.class, PropertyFilterMixIn.class);
        String[] ignorableFieldNames = logProperties.getExcludeFields().toArray(new String[0]);

        FilterProvider filters = new SimpleFilterProvider().addFilter("filter properties by name",
                SimpleBeanPropertyFilter.serializeAllExcept(ignorableFieldNames));
        objectMapper.setFilterProvider(filters);
        objectMapper.registerModule(new PigJavaTimeModule());
    }

    @JsonFilter("filter properties by name")
    class PropertyFilterMixIn {

    }
}
    