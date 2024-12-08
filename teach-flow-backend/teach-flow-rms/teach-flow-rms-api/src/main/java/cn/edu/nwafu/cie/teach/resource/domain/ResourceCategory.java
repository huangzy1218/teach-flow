package cn.edu.nwafu.cie.teach.resource.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

/**
 * 资源分类。
 *
 * @author Huang Z.Y.
 * @create 2024-11-23 23:46
 */
@TableName(value = "resource_category")
@Data
public class ResourceCategory implements Serializable {
    @Serial
    @TableField(exist = false)
    private static final long serialVersionUID = 3118502393095699986L;
    /**
     * 课程 ID
     */
    @TableId(type = IdType.NONE)
    private Integer cid;

    /**
     * 资源 ID
     */
    private Integer rid;
}
    