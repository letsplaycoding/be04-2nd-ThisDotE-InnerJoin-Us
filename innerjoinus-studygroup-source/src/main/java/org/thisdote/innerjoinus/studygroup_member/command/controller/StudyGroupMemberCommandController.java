package org.thisdote.innerjoinus.studygroup_member.command.controller;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.thisdote.innerjoinus.studygroup_member.command.service.StudyGroupMemberCommandService;
import org.thisdote.innerjoinus.studygroup_member.command.vo.RequestModifyStudyGroupMember;
import org.thisdote.innerjoinus.studygroup_member.command.vo.RequestStudyGroupMember;
import org.thisdote.innerjoinus.studygroup_member.command.vo.ResponseModifyStudyGroupMember;
import org.thisdote.innerjoinus.studygroup_member.command.vo.ResponseStudyGroupMember;
import org.thisdote.innerjoinus.studygroup_member.dto.StudyGroupMemberDTO;

@RestController
@RequestMapping("/")
public class StudyGroupMemberCommandController {

    private Environment env;
    private ModelMapper modelMapper;
    private StudyGroupMemberCommandService studyGroupMemberCommandService;

    @Autowired
    public StudyGroupMemberCommandController(Environment env,
                                             ModelMapper modelMapper,
                                             StudyGroupMemberCommandService studyGroupMemberCommandService) {
        this.env = env;
        this.modelMapper = modelMapper;
        this.studyGroupMemberCommandService = studyGroupMemberCommandService;
    }

    // 서버와 연결 확인용 테스트
//    @GetMapping("/a")
//    public String status() {
//        return "Server at" + env.getProperty("local.server.port") +
//                ", swcamp.message: " + env.getProperty("swcamp.message");
//    }

    // 스터디원 추가하기 - regist(insert)
    @PostMapping("/member/regist")
    public ResponseEntity<ResponseStudyGroupMember> registStudyGroupMember
                                                    (@RequestBody RequestStudyGroupMember studyGroupMember) {

        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        StudyGroupMemberDTO studyGroupMemberDTO = modelMapper.map(studyGroupMember, StudyGroupMemberDTO.class);
        System.out.println("studyGroupMemberDTO = " + studyGroupMemberDTO);

        studyGroupMemberCommandService.registStudyGroupMember(studyGroupMemberDTO);
        ResponseStudyGroupMember responseStudyGroupMember = modelMapper.map(studyGroupMemberDTO,
                                                                            ResponseStudyGroupMember.class);

        return ResponseEntity.status(HttpStatus.OK).body(responseStudyGroupMember);
    }

    // 스터디원 수정하기 - modify(update)
    @PostMapping("/member/modify")
    public ResponseEntity<ResponseModifyStudyGroupMember> modifyStudyGroupMember (@RequestBody RequestModifyStudyGroupMember
                                                                                        modifyStudyGroupMember) {
        StudyGroupMemberDTO studyGroupMemberDTO = modelMapper.map(modifyStudyGroupMember, StudyGroupMemberDTO.class);
        studyGroupMemberCommandService.modifyStudyGroupMemberRole(studyGroupMemberDTO);

        ResponseModifyStudyGroupMember responseModifyStudyGroupMember = new ResponseModifyStudyGroupMember();
        responseModifyStudyGroupMember.setStudyGroupId(studyGroupMemberDTO.getStudyGroupId());
        responseModifyStudyGroupMember.setStudyGroupRole(0);
        responseModifyStudyGroupMember.setStudyGroupRegistDate(studyGroupMemberDTO.getStudyGroupRegistDate());
        responseModifyStudyGroupMember.setUserCode(studyGroupMemberDTO.getUserCode());

        return ResponseEntity.status(HttpStatus.ACCEPTED).body(responseModifyStudyGroupMember);
    }
}
