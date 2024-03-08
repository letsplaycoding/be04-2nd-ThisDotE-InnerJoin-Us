package org.thisdote.innerjoinus.studygroup.command.service;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.thisdote.innerjoinus.studygroup.command.entity.StudyGroupEntity;
import org.thisdote.innerjoinus.studygroup.command.repository.StudyGroupRepository;
import org.thisdote.innerjoinus.studygroup.dto.StudyGroupCommandDTO;

import java.util.Date;

@Service
public class StudyGroupCommandServiceImpl implements StudyGroupCommandService{
    private ModelMapper mapper;
    private StudyGroupRepository studygroupRepository;

    public StudyGroupCommandServiceImpl(ModelMapper mapper, StudyGroupRepository studygroupRepository) {
        this.mapper = mapper;
        this.studygroupRepository = studygroupRepository;
    }

    @Transactional
    @Override
    public StudyGroupCommandDTO insertStudygroup(StudyGroupCommandDTO studyGroupCommandDTO) {
        Date createdDate = new Date();
        studyGroupCommandDTO.setStudygroupCreateDate(createdDate);
        studyGroupCommandDTO.setStudygroupActivationStatus(1);
        studyGroupCommandDTO.setStudygroupDeleteStatus(0);

        mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        StudyGroupEntity studyGroupEntity = mapper.map(studyGroupCommandDTO, StudyGroupEntity.class);

        studygroupRepository.save(studyGroupEntity);
        return studyGroupCommandDTO;
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
