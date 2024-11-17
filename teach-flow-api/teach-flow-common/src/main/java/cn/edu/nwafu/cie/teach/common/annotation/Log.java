package cn.edu.nwafu.cie.teach.common.annotation;

import cn.edu.nwafu.cie.teach.common.constant.BusinessTypeConstant;

/**
 * 日志注解。
 *
 * @author Huang Z.Y.
 * @create 2024-11-17 23:11
 */
public @interface Log {
    /**
     * 标题
     */
    public String title() default "";

    /**
     * 功能
     */
    public BusinessTypeConstant businessType() default BusinessTypeConstant.OTHER;
}
