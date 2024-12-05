package cn.edu.nwafu.cie.teach.user.api.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.List;

/**
 * 用户导入请求体。
 *
 * @author Huang Z.Y.
 * @create 2024-12-01 22:40
 */
@Data
public class UserImportRequest {
    @Data
    public static class UserItem {
        private String deps;
        private String email;
        private String name;
        private String password;

        @JsonProperty("id_card")
        private String idCard;
    }

    @NotNull(message = "请导入数据")
    private List<UserItem> users;
}
    