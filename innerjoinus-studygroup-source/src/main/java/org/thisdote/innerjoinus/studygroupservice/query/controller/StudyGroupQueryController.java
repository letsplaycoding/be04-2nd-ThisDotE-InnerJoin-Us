package org.thisdote.innerjoinus.studygroupservice.query.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.thisdote.innerjoinus.studygroupservice.dto.StudyGroupDTO;
import org.thisdote.innerjoinus.studygroupservice.query.service.StudyGroupService;
import org.thisdote.innerjoinus.studygroupservice.query.vo.ResponseStudyGroup;

import java.util.List;

@RestController
@RequestMapping("/")
public class StudyGroupQueryController {

    private Environment env;
    private ModelMapper mapper;
    private StudyGroupService studyGroupService;

    @Autowired
    public StudyGroupQueryController(Environment env,
                                     ModelMapper mapper, StudyGroupService studyGroupService) {
        this.env = env;
        this.mapper = mapper;
        this.studyGroupService = studyGroupService;
    }

    @GetMapping("/studygroups")
    public List<StudyGroupDTO> getAllStudyGroup() {
        List<StudyGroupDTO> studyGroupDTOList = studyGroupService.viewAllStudyGroup();
        return studyGroupDTOList;
    }

    /* 필기. 게시글 생성(Insert) */
    @PostMapping("/studygroups")
    public
}
