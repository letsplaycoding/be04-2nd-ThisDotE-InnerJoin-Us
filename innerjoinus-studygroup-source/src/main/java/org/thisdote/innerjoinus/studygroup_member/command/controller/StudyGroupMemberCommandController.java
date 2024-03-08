package org.thisdote.innerjoinus.studygroup_member.command.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.thisdote.innerjoinus.studygroup_member.query.service.StudyGroupMemberService;

@RestController
@RequestMapping("/")
public class StudyGroupMemberCommandController {

    private Environment env;
    private ModelMapper modelMapper;
    private StudyGroupMemberService studyGroupMemberService;

    @Autowired
    public StudyGroupMemberCommandController(Environment env, ModelMapper modelMapper, StudyGroupMemberService studyGroupMemberService) {
        this.env = env;
        this.modelMapper = modelMapper;
        this.studyGroupMemberService = studyGroupMemberService;
    }

    // 서버와 연결 확인용 테스트
//    @GetMapping("/a")
//    public String status() {
//        return "Server at" + env.getProperty("local.server.port") +
//                ", swcamp.message: " + env.getProperty("swcamp.message");
//    }


}
