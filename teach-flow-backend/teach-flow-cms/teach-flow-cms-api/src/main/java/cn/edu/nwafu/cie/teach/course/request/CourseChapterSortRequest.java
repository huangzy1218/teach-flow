package cn.edu.nwafu.cie.teach.course.request;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.List;

/**
 * 课程章节排序请求体。
 *
 * @author Huang Z.Y.
 * @create 2024-12-01 23:55
 */
@Data
public class CourseChapterSortRequest {
    @NotNull(message = "ids 参数不存在")
    private List<Integer> ids;
}
    