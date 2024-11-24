package cn.edu.nwafu.cie.teach.user.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

/**
 * 管理权限。
 *
 * @author Huang Z.Y.
 * @create 2024-11-24 00:15
 */
@TableName(value = "admin_permission")
@Data
public class AdminPermission implements Serializable {
    @TableField(exist = false)
    @Serial
    private static final long serialVersionUID = 5487504274950748562L;

    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 类型[行为:action,数据:data]
     */
    private String type;

    /**
     * 分组
     */
    @JsonProperty("group_name")
    private String groupName;

    /**
     * 升序
     */
    private Integer sort;

    /**
     * 权限名
     */
    private String name;

    /**
     * slug
     */
    private String slug;

    @JsonProperty("created_at")
    private Date createdAt;
}
    