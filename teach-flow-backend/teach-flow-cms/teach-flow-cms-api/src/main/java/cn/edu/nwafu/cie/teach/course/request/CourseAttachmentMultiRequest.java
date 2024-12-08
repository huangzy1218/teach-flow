package cn.edu.nwafu.cie.teach.course.request;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.List;

/**
 * 课程附件请求体。
 *
 * @author Huang Z.Y.
 * @create 2024-12-01 23:04
 */
@Data
public class CourseAttachmentMultiRequest {
    @Data
    public static class AttachmentItem {
        private String title;
        private Integer sort;
        private String type;
        private Integer rid;
    }

    @NotNull(message = "attachments 参数不存在")
    private List<AttachmentItem> attachments;
}
    