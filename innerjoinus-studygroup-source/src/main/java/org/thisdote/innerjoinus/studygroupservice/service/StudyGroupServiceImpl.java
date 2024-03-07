package org.thisdote.innerjoinus.studygroupservice.service;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.thisdote.innerjoinus.studygroupservice.entity.StudyGroupEntity;
import org.thisdote.innerjoinus.studygroupservice.repository.StudyGroupRepository;
import org.thisdote.innerjoinus.studygroupservice.dto.StudyGroupDTO;

@Service
public class StudyGroupServiceImpl implements StudyGroupService{

    private final StudyGroupRepository studyGroupRepository;
    private final ModelMapper mapper;

    @Autowired
    public StudyGroupServiceImpl(StudyGroupRepository studyGroupRepository, ModelMapper mapper) {
        this.studyGroupRepository = studyGroupRepository;
        this.mapper = mapper;
    }

    @Transactional
    @Override
    public void registStudyGroup(StudyGroupDTO studyGroupDTO) {

        mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        StudyGroupEntity studyGroupEntity = mapper.map(studyGroupDTO, StudyGroupEntity.class);

        studyGroupRepository.save(studyGroupEntity);
    }
}
