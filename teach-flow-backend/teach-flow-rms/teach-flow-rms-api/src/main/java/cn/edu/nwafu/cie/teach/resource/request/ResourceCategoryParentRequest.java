package cn.edu.nwafu.cie.teach.resource.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.List;

/**
 * 资源类别父请求体。
 *
 * @author Huang Z.Y.
 * @create 2024-12-07 21:32
 */
@Data
public class ResourceCategoryParentRequest {
    @NotNull(message = "参数为空")
    private List<Integer> ids;

    @NotNull(message = "参数为空")
    private Integer id;

    @NotNull(message = "参数为空")
    @JsonProperty("parent_id")
    private Integer parentId;
}
    