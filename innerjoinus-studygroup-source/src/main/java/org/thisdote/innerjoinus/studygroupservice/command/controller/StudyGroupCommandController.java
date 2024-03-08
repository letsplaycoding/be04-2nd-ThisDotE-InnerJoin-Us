package org.thisdote.innerjoinus.studygroupservice.command.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.thisdote.innerjoinus.studygroupservice.command.service.StudyGroupCommandService;
import org.thisdote.innerjoinus.studygroupservice.command.vo.*;
import org.thisdote.innerjoinus.studygroupservice.dto.StudyGroupCommandDTO;

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

    /* 필기. Update */
    @PostMapping("/studygroup/update")
    public ResponseEntity<ResponseModifyStudyGroup>
                    modifyStudyGroup(@RequestBody RequestModifyStudyGroup modifyStudyGroup){
        StudyGroupCommandDTO studyGroupCommandDTO = mapper.map(modifyStudyGroup, StudyGroupCommandDTO.class);
        System.out.println("studyGroupCommandDTO = " + studyGroupCommandDTO);

        studyGroupCommandService.updateStudyGroup(studyGroupCommandDTO);

        ResponseModifyStudyGroup responseModifyStudyGroup = mapper.map(studyGroupCommandDTO,ResponseModifyStudyGroup.class);

        return ResponseEntity.status(HttpStatus.ACCEPTED).body(responseModifyStudyGroup);
    }

    @PostMapping("/studygroup/delete")
    public ResponseEntity<ResponseDeleteStudyGroup>
                    deleteStudyGroup(@RequestBody RequestDeleteStudyGroup deleteStudyGroup) {
        StudyGroupCommandDTO studyGroupCommandDTO =mapper.map(deleteStudyGroup, StudyGroupCommandDTO.class);
        System.out.println("studyGroupCommandDTO = " + studyGroupCommandDTO);
        studyGroupCommandService.removeStudyGroup(studyGroupCommandDTO);

        ResponseDeleteStudyGroup responseDeleteStudyGroup = mapper.map(studyGroupCommandDTO, ResponseDeleteStudyGroup.class);

        return ResponseEntity.status(HttpStatus.ACCEPTED).body(responseDeleteStudyGroup);
    }
}
