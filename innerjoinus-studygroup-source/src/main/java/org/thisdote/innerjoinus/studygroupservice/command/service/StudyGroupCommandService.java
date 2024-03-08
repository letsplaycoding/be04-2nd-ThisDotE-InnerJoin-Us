package org.thisdote.innerjoinus.studygroupservice.command.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.thisdote.innerjoinus.studygroupservice.command.entity.StudyGroupEntity;
import org.thisdote.innerjoinus.studygroupservice.command.repository.StudyGroupRepository;
import org.thisdote.innerjoinus.studygroupservice.dto.StudyGroupCommandDTO;

import java.util.Date;

@Service
public class StudyGroupCommandService {

    private ModelMapper mapper;
    private StudyGroupRepository studygroupRepository;

    @Autowired
    public StudyGroupCommandService(ModelMapper mapper, StudyGroupRepository studygroupRepository) {
        this.mapper = mapper;
        this.studygroupRepository = studygroupRepository;
    }


    @Transactional
    public void registStudygroup(StudyGroupCommandDTO newStudygroup) {
        StudyGroupEntity studygroupEntity = mapper.map(newStudygroup, StudyGroupEntity.class);
        studygroupRepository.save(studygroupEntity);
    }

    @Transactional
    public void deleteStudyGroup(StudyGroupCommandDTO studyGroupDTO, int studygroupId) {
        StudyGroupEntity studygroup = studygroupRepository.findById(studygroupId).get();
        studygroup.setStudygroupDeleteStatus(studyGroupDTO.getStudygroupDeleteStatus());
    }

    @Transactional
    public void modifyStudygroup(StudyGroupCommandDTO studygroup) {
        StudyGroupEntity studyGroupEntity = mapper.map(studygroup, StudyGroupEntity.class);
        studygroupRepository.save(studyGroupEntity);
    }

    public void insertStudygroup(StudyGroupCommandDTO studyGroupCommandDTO) {
        StudyGroupEntity studyGroupEntity = mapper.map(studyGroupCommandDTO, StudyGroupEntity.class);
        studygroupRepository.save(studyGroupEntity);
    }

    @Transactional
    public void updateStudyGroup(StudyGroupCommandDTO studyGroupCommandDTO) {
        StudyGroupEntity studyGroup = studygroupRepository
                .findById(studyGroupCommandDTO.getStudygroupId()).get();
        studyGroup.setStudygroupId(studyGroupCommandDTO.getStudygroupId());
        studyGroup.setStudygroupType(studyGroupCommandDTO.getStudygroupType());
        studyGroup.setStudygroupCreateDate(studyGroupCommandDTO.getStudygroupCreateDate());
        studyGroup.setStudygroupMemberCount(studyGroupCommandDTO.getStudygroupMemberCount());
        studyGroup.setStudygroupActivationStatus(studyGroupCommandDTO.getStudygroupActivationStatus());
        studyGroup.setStudygroupStudyTime(studyGroupCommandDTO.getStudygroupStudyTime());
        studyGroup.setStudygroupContent(studyGroupCommandDTO.getStudygroupContent());
        studyGroup.setStudygroupDeleteStatus(studyGroupCommandDTO.getStudygroupDeleteStatus());
    }
}
