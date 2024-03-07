package org.thisdote.innerjoinus.studygroupservice.command.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.thisdote.innerjoinus.studygroupservice.command.service.StudyGroupCommandService;
import org.thisdote.innerjoinus.studygroupservice.command.vo.RequestModifyStudyGroup;
import org.thisdote.innerjoinus.studygroupservice.command.vo.RequestStudyGroup;
import org.thisdote.innerjoinus.studygroupservice.command.vo.ResponseModifyStudyGroup;
import org.thisdote.innerjoinus.studygroupservice.dto.StudyGroupCommandDTO;
import org.thisdote.innerjoinus.studygroupservice.command.vo.ResponseStudyGroup;

@RestController
@RequestMapping("/")
public class StudyGroupCommandController {

    private ModelMapper mapper;
    private StudyGroupCommandService studyGroupCommandService;

    @Autowired
    public StudyGroupCommandController(ModelMapper mapper, StudyGroupCommandService studyGroupCommandService) {
        this.mapper = mapper;
        this.studyGroupCommandService = studyGroupCommandService;
    }

    /* 필기. Insert */
    @PostMapping("/studygroup/insert")
    public ResponseEntity<ResponseStudyGroup> registStudyGroup(@RequestBody RequestStudyGroup studyGroup) {

        StudyGroupCommandDTO studyGroupCommandDTO = mapper.map(studyGroup, StudyGroupCommandDTO.class);
        System.out.println("studyGroupDTO = " + studyGroupCommandDTO);

        studyGroupCommandService.insertStudygroup(studyGroupCommandDTO);

        ResponseStudyGroup responseStudyGroup = mapper.map(studyGroupCommandDTO, ResponseStudyGroup.class);

        return ResponseEntity.status(HttpStatus.CREATED).body(responseStudyGroup);
    }
    @PostMapping("/studygroup/update/{studygroupId}")
    public ResponseEntity<ResponseModifyStudyGroup> modifyArticle(@RequestBody RequestModifyStudyGroup modifyStudyGroup){
        StudyGroupCommandDTO studyGroupCommandDTO = mapper.map(modifyStudyGroup, StudyGroupCommandDTO.class);
        studyGroupCommandService.updateStudyGroup(studyGroupCommandDTO);

        ResponseModifyStudyGroup responseModifyStudyGroup = new ResponseModifyStudyGroup();

        return ResponseEntity.status(HttpStatus.ACCEPTED).body(responseModifyStudyGroup);
    }
}
