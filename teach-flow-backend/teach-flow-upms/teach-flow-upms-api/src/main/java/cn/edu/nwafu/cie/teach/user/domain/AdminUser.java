package cn.edu.nwafu.cie.teach.user.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

/**
 * 管理员。
 *
 * @author Huang Z.Y.
 * @create 2024-11-24 00:24
 */
@TableName(value = "admin_users")
@Data
@Slf4j
public class AdminUser implements Serializable {
    @Serial
    @TableField(exist = false)
    private static final long serialVersionUID = -2734826400792562070L;

    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 姓名
     */
    private String name;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 密码
     */
    @JsonIgnore
    private String password;

    /**
     * Salt
     */
    @JsonIgnore
    private String salt;

    /**
     * 登录 IP
     */
    @JsonProperty("login_ip")
    private String loginIp;

    /**
     * 登录时间
     */
    @JsonProperty("login_at")
    private Date loginAt;

    /**
     * 1禁止登录,0否
     */
    @JsonProperty("is_ban_login")
    private Integer isBanLogin;

    /**
     * 登录次数
     */
    @JsonProperty("login_times")
    private Integer loginTimes;

    @JsonProperty("created_at")
    private Date createdAt;

    @JsonProperty("updated_at")
    private Date updatedAt;
}
    