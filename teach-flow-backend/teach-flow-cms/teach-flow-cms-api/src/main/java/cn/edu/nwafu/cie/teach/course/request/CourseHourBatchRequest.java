package cn.edu.nwafu.cie.teach.course.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.List;

/**
 * 批量导入课时请求体。
 *
 * @author Huang Z.Y.
 * @create 2024-12-02 21:59
 */
@Data
public class CourseHourBatchRequest {
    @Data
    public static class HourItem {
        @JsonProperty("chapter_id")
        private Integer chapterId;

        private String title;
        private Integer duration;
        private Integer sort;
        private String type;
        private Integer rid;
    }

    @NotNull(message = "hours参数不存在")
    private List<HourItem> hours;
}
    