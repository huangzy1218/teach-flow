package cn.edu.nwafu.cie.teach.course.request;

import lombok.Data;

import java.util.List;

/**
 * 课程附件排序请求。
 *
 * @author Huang Z.Y.
 * @create 2024-12-01 23:08
 */
@Data
public class CourseAttachmentSortRequest {
    private List<Integer> ids;
}
    