package cn.edu.nwafu.cie.teach.course.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

/**
 * 章节请求体。
 *
 * @author Huang Z.Y.
 * @create 2024-12-01 23:52
 */
@Data
public class CourseChapterRequest {
    @NotBlank(message = "请输入章节名")
    @Length(min = 1, max = 64, message = "章节名长度在1-64个字符之间")
    private String name;

    @NotNull(message = "sort参数不存在")
    private Integer sort;
}
    