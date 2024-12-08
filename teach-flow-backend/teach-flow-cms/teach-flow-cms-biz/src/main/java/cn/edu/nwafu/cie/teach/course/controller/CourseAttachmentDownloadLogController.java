package cn.edu.nwafu.cie.teach.course.controller;

import cn.edu.nwafu.cie.teach.common.api.R;
import cn.edu.nwafu.cie.teach.common.log.annotation.Log;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

/**
 * @author Huang Z.Y.
 * @create 2024-12-01 23:49
 */
@RestController
@Slf4j
@RequestMapping("/v1/course/attachment/download/log")
public class CourseAttachmentDownloadLogController {
    @GetMapping("/index")
    @Log("学员下载课件记录-列表")
    public R index(@RequestParam HashMap<String, Object> params) {
        return R.success();
    }
}
    