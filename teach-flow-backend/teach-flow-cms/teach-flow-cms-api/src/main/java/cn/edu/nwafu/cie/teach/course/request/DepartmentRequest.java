package cn.edu.nwafu.cie.teach.course.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

import java.io.Serial;
import java.io.Serializable;

/**
 * @author Huang Z.Y.
 * @create 2024-12-02 22:16
 */
public class DepartmentRequest implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @NotBlank(message = "请输入部门名称")
    @Length(min = 1, max = 20, message = "部门名称长度在1-20个字符之间")
    private String name;

    @JsonProperty("parent_id")
    @NotNull(message = "parent_id参数不存在")
    private Integer parentId;

    @NotNull(message = "sort参数不存在")
    private Integer sort;
}
    