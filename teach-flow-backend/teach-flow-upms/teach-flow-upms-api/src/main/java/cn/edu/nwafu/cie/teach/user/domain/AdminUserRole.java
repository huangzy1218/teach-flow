package cn.edu.nwafu.cie.teach.user.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serial;
import java.io.Serializable;

/**
 * 管理员用户角色。
 *
 * @author Huang Z.Y.
 * @create 2024-11-24 00:29
 */
public class AdminUserRole implements Serializable {
    @Serial
    @TableField(exist = false)
    private static final long serialVersionUID = 9011145244899063442L;

    @TableId(type = IdType.NONE)
    @JsonProperty("admin_id")
    private Integer adminId;

    @JsonProperty("role_id")
    private Integer roleId;
}
    