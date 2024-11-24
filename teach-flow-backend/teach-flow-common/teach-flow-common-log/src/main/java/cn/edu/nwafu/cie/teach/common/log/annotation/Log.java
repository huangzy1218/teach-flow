package cn.edu.nwafu.cie.teach.common.log.annotation;

import java.lang.annotation.*;

/**
 * 操作日志注解。
 *
 * @author Huang Z.Y.
 * @create 2024-11-24 23:51
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Log {
    /**
     * 描述
     *
     * @return {String}
     */
    String value() default "";

    /**
     * spel 表达式
     *
     * @return 日志描述
     */
    String expression() default "";
}
    