package cn.edu.nwafu.cie.teach.course.request;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.List;

/**
 * @author Huang Z.Y.
 * @create 2024-12-02 22:08
 */
@Data
public class CourseUserDeleteRequest {
    @NotNull(message = "ids 参数不存在")
    private List<Integer> ids;
}
    