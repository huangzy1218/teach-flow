package cn.edu.nwafu.cie.teach.course.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

/**
 * 课程附件请求体，
 *
 * @author Huang Z.Y.
 * @create 2024-12-01 23:02
 */
@Data
public class CourseAttachmentRequest {
    @NotBlank(message = "请输入附件名称")
    private String title;

    @NotNull(message = "sort参数不存在")
    private Integer sort;

    @NotBlank(message = "请选择附件类型")
    private String type;

    @NotNull(message = "rid参数不存在")
    private Integer rid;
}
    