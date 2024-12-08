package cn.edu.nwafu.cie.teach.resource.request;

import lombok.Data;

import java.util.List;

/**
 * 批量删除资源请求体。
 *
 * @author Huang Z.Y.
 * @create 2024-12-07 21:36
 */
@Data
public class ResourceDeleteBatchRequest {
    private List<Integer> ids;
}
    