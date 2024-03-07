package org.thisdote.innerjoinus.studygroupservice.command.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.thisdote.innerjoinus.studygroupservice.command.service.StudyGroupCommandService;
import org.thisdote.innerjoinus.studygroupservice.dto.StudyGroupCommandDTO;
import org.thisdote.innerjoinus.studygroupservice.dto.StudyGroupDTO;
import org.thisdote.innerjoinus.studygroupservice.query.vo.ResponseStudyGroup;

import java.util.List;

@RestController
@RequestMapping("/")
public class StudyGroupController {

    private Environment env;
    private ModelMapper mapper;
    private StudyGroupCommandService studyGroupCommandService;

    @Autowired
    public StudyGroupController(Environment env,
                                ModelMapper mapper, StudyGroupCommandService studyGroupCommandService) {
        this.env = env;
        this.mapper = mapper;
        this.studyGroupCommandService = studyGroupCommandService;
    }

//    @GetMapping("/studygroup")
//    public ResponseEntity<List<ResponseStudyGroup>> getStudyGroups(@PathVariable("studygroupId") int studyGroupId) {
//
//    }

    /* 필기. 게시글 생성(Insert) */
    @PostMapping("/studygroups")
    public ResponseEntity<ResponseStudyGroup> registStudyGroup(@RequestBody ResponseStudyGroup studyGroup) {

        StudyGroupDTO studyGroupDTO = mapper.map(studyGroup, StudyGroupDTO.class);
        System.out.println("studyGroupDTO = " + studyGroupDTO);

        studyGroupCommandService.registStudygroup(new StudyGroupCommandDTO());

        ResponseStudyGroup responseStudyGroup = mapper.map(studyGroupDTO, ResponseStudyGroup.class);

        return ResponseEntity.status(HttpStatus.CREATED).body(responseStudyGroup);
    }
}
