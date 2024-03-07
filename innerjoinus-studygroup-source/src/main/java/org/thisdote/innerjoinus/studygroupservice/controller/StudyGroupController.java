package org.thisdote.innerjoinus.studygroupservice.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.thisdote.innerjoinus.studygroupservice.vo.ResponseStudyGroup;
import org.thisdote.innerjoinus.studygroupservice.dto.StudyGroupDTO;
import org.thisdote.innerjoinus.studygroupservice.service.StudyGroupService;
import org.thisdote.innerjoinus.studygroupservice.vo.StudyGroupVo;

@RestController
@RequestMapping("/")
public class StudyGroupController {

    private Environment env;
    private StudyGroupVo studyGroupVo;
    private ModelMapper mapper;
    private StudyGroupService studyGroupService;

    @Autowired
    public StudyGroupController(Environment env, StudyGroupVo studyGroupVo,
                                ModelMapper mapper, StudyGroupService studyGroupService) {
        this.env = env;
        this.studyGroupVo = studyGroupVo;
        this.mapper = mapper;
        this.studyGroupService = studyGroupService;
    }

    @GetMapping("/studygroup")
    public String StudyGroupStatus() {
        return "게시글 전체 조회 " + env.getProperty("게시글 전체 조회 테스트");
    }

    /* 필기. 게시글 생성(Insert) */
    @PostMapping("/studygroups")
    public ResponseEntity<ResponseStudyGroup> registStudyGroup(@RequestBody ResponseStudyGroup studyGroup) {

        /* 설명. config server에서 제공하는 test.message값 확인 */
        System.out.println("config server의 설정값 확인: "
                +env.getProperty("test.message"));

        StudyGroupDTO studyGroupDTO = mapper.map(studyGroup, StudyGroupDTO.class);
        System.out.println("studyGroupDTO = " + studyGroupDTO);

        studyGroupService.registStudyGroup(studyGroupDTO);

        ResponseStudyGroup responseStudyGroup = mapper.map(studyGroupDTO, ResponseStudyGroup.class);

        return ResponseEntity.status(HttpStatus.CREATED).body(responseStudyGroup);
    }
}
