package cn.edu.nwafu.cie.teach.user.api.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import java.io.Serial;
import java.io.Serializable;

/**
 * 管理员角色请求体。
 *
 * @author Huang Z.Y.
 * @create 2024-11-28 23:24
 */
@Data
public class AdminRoleRequest implements Serializable {
    @Serial
    private static final long serialVersionUID = -1502932292450943481L;

    @NotBlank(message = "请输入管理角色名")
    @Length(min = 1, max = 12, message = "管理角色名长度在 1-16 个字符之间")
    private String name;

    @JsonProperty("permission_ids")
    @NotNull(message = "permission_ids 参数不存在")
    private Integer[] permissionIds;
}
    