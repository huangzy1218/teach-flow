package cn.edu.nwafu.cie.teach.course.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

/**
 * 用户最新学习进展。
 *
 * @author Huang Z.Y.
 * @create 2024-11-23 23:23
 */
@Data
public class UserLatestLearn implements Serializable {
    @Serial
    private static final long serialVersionUID = 6155952356947815398L;

    @JsonProperty("course")
    private Course course;

    @JsonProperty("record")
    private UserCourseRecord userCourseRecord;

    @JsonProperty("last_learn_hour")
    private CourseHour lastLearnHour;

    @JsonProperty("hour_record")
    private UserCourseHourRecord hourRecord;
}
    