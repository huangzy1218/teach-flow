package cn.edu.nwafu.cie.teach.user.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

/**
 * 用户登录记录。
 *
 * @author Huang Z.Y.
 * @create 2024-11-24 00:42
 */
@TableName(value = "user_login_records")
@Data
public class UserLoginRecord implements Serializable {
    @Serial
    @TableField(exist = false)
    private static final long serialVersionUID = 8444611574420495285L;

    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 用户 ID
     */
    private Integer userId;

    /**
     * JTI
     */
    private String jti;

    /**
     * 登录 IP
     */
    private String ip;

    /**
     * IP 解析区域
     */
    private String ipArea;

    /**
     * 浏览器
     */
    private String browser;

    /**
     * 浏览器版本
     */
    private String browserVersion;

    /**
     * 操作系统
     */
    private String os;

    /**
     * 过期时间
     */
    private Long expired;

    /**
     * 是否注销
     */
    private Integer isLogout;

    /**
     * 创建时间
     */
    private Date createdAt;
}
    