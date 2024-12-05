package cn.edu.nwafu.cie.teach.user.api.request;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.HashMap;

/**
 * 应用配置请求体。
 *
 * @author Huang Z.Y.
 * @create 2024-11-28 23:53
 */
@Data
public class AppConfigRequest {
    @NotNull(message = "配置为空")
    private HashMap<String, String> data;
}
    