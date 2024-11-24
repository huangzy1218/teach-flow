package cn.edu.nwafu.cie.teach.gateway.config;

import cn.edu.nwafu.cie.teach.gateway.filter.RequestGlobalFilter;
import cn.edu.nwafu.cie.teach.gateway.handler.GlobalExceptionHandler;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 网关配置。
 *
 * @author Huang Z.Y.
 * @create 2024-11-25 22:12
 */
@Configuration(proxyBeanMethods = false)
public class GatewayConfig {
    /**
     * 创建 Request 全局过滤器
     *
     * @return Request 全局过滤器
     */
    @Bean
    public RequestGlobalFilter requestGlobalFilter() {
        return new RequestGlobalFilter();
    }

    /**
     * 创建全局异常处理程序
     *
     * @param objectMapper 对象映射器
     * @return 全局异常处理程序
     */
    @Bean
    public GlobalExceptionHandler globalExceptionHandler(ObjectMapper objectMapper) {
        return new GlobalExceptionHandler(objectMapper);
    }
}
    