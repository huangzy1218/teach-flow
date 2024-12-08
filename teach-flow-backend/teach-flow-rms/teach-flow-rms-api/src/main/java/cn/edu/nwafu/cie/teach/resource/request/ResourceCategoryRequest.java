package cn.edu.nwafu.cie.teach.resource.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

/**
 * 资源类别请求体。
 *
 * @author Huang Z.Y.
 * @create 2024-12-07 21:26
 */
@Data
public class ResourceCategoryRequest {
    @NotBlank(message = "请输入分类名")
    @Length(min = 1, max = 20, message = "分类名长度在1-20个字符之间")
    private String name;

    @JsonProperty("parent_id")
    @NotNull(message = "parent_id参数不存在")
    private Integer parentId;

    @NotNull(message = "sort参数不存在")
    private Integer sort;
}
    