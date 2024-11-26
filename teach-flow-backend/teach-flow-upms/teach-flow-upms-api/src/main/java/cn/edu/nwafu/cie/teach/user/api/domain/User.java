package cn.edu.nwafu.cie.teach.user.api.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

/**
 * 普通用户。
 *
 * @author Huang Z.Y.
 * @create 2024-11-24 00:39
 */
@TableName(value = "user")
@Data
public class User implements Serializable {
    @Serial
    @TableField(exist = false)
    private static final long serialVersionUID = -1310677938839419480L;

    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 邮件
     */
    private String email;

    /**
     * 真实姓名
     */
    private String name;

    /**
     * 头像
     */
    private String avatar;

    /**
     * 密码
     */
    @JsonIgnore
    private String password;

    /**
     * 学院 ID
     */
    @JsonProperty("dep_id")
    private Integer depId;

    /**
     * salt
     */
    @JsonIgnore
    private String salt;

    /**
     * 身份证号
     */
    @JsonProperty("id_card")
    private String idCard;

    /**
     * 学分
     */
    private Integer credit1;

    /**
     * 注册 IP
     */
    @JsonProperty("create_ip")
    private String createIp;

    /**
     * 注册城市
     */
    @JsonProperty("create_city")
    private String createCity;

    /**
     * 激活[1:是,0:否]
     */
    @JsonProperty("is_active")
    private Integer isActive;

    /**
     * 锁定[1:是,0:否]
     */
    @JsonProperty("is_lock")
    private Integer isLock;

    /**
     * 实名认证[1:是,0:否]
     */
    @JsonProperty("is_verify")
    private Integer isVerify;

    /**
     * 实名认证时间
     */
    @JsonProperty("verify_at")
    private Date verifyAt;

    /**
     * 设置密码[1:是,0:否]
     */
    @JsonProperty("is_set_password")
    private Integer isSetPassword;

    /**
     * 登录时间
     */
    @JsonProperty("login_at")
    private Date loginAt;

    @JsonProperty("created_at")
    private Date createdAt;

    @JsonProperty("updated_at")
    private Date updatedAt;
}
    