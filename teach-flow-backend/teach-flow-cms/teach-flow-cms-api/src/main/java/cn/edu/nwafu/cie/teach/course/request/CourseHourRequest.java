package cn.edu.nwafu.cie.teach.course.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

/**
 * 课时请求体，
 *
 * @author Huang Z.Y.
 * @create 2024-12-02 21:53
 */
@Data
public class CourseHourRequest {
    @NotNull(message = "chapter_id 参数不存在")
    @JsonProperty("chapter_id")
    private Integer chapterId;

    @NotBlank(message = "请输入课时标题")
    private String title;

    @NotNull(message = "duration参数不存在")
    private Integer duration;

    @NotNull(message = "sort参数不存在")
    private Integer sort;

    @NotBlank(message = "请选择课时类型")
    private String type;
    @NotNull(message = "rid参数不存在")
    private Integer rid;
}
    