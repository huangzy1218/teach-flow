package cn.edu.nwafu.cie.teach.course.request;

import lombok.Data;

import java.util.List;

/**
 * 课程时数排序请求体。
 *
 * @author Huang Z.Y.
 * @create 2024-12-02 22:03
 */
@Data
public class CourseHourSortRequest {
    private List<Integer> ids;
}
    