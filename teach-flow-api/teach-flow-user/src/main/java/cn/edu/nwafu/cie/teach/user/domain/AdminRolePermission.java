package cn.edu.nwafu.cie.teach.user.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

/**
 * 管理员角色权限。
 *
 * @author Huang Z.Y.
 * @create 2024-11-24 00:21
 */
@TableName(value = "admin_role_permission")
@Data
public class AdminRolePermission implements Serializable {
    @Serial
    @TableField(exist = false)
    private static final long serialVersionUID = 4427517796640077234L;

    @TableId(type = IdType.NONE)
    @JsonProperty("role_id")
    private Integer roleId;

    @JsonProperty("perm_id")
    private Integer permId;
}
    