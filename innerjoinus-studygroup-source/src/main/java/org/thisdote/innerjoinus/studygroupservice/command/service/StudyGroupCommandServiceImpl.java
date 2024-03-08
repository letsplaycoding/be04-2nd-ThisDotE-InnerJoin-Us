package org.thisdote.innerjoinus.studygroupservice.command.service;

import org.modelmapper.ModelMapper;
import org.springframework.transaction.annotation.Transactional;
import org.thisdote.innerjoinus.studygroupservice.command.entity.StudyGroupEntity;
import org.thisdote.innerjoinus.studygroupservice.command.repository.StudyGroupRepository;
import org.thisdote.innerjoinus.studygroupservice.dto.StudyGroupCommandDTO;

public class StudyGroupCommandServiceImpl implements StudyGroupCommandService{
    private ModelMapper mapper;
    private StudyGroupRepository studygroupRepository;

    @Transactional
    @Override
    public void insertStudygroup(StudyGroupCommandDTO studyGroupCommandDTO) {
        StudyGroupEntity studyGroupEntity = mapper.map(studyGroupCommandDTO, StudyGroupEntity.class);
        studygroupRepository.save(studyGroupEntity);
    }

    @Transactional
    @Override
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

    @Transactional
    @Override
    public void removeStudyGroup(StudyGroupCommandDTO studyGroupCommandDTO) {
        StudyGroupEntity studyGroup = studygroupRepository
                .findById(studyGroupCommandDTO.getStudygroupId()).get();
        studyGroup.setStudygroupId(studyGroupCommandDTO.getStudygroupId());
        studyGroup.setStudygroupDeleteStatus(studyGroupCommandDTO.getStudygroupDeleteStatus());

    }
}
