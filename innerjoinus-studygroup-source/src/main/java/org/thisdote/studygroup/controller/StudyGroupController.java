package org.thisdote.studygroup.controller;

import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.thisdote.studygroup.vo.StudyGroupVo;

@RestController
@RequestMapping("/")
public class StudyGroupController {

    private Environment env;
    private StudyGroupVo studyGroupVo;

    @GetMapping("/studygroup")
    public String StudyGroupStatus() {
        return "게시글 전체 조회 " + env.getProperty("게시글 전체 조회 테스트");
    }

}
