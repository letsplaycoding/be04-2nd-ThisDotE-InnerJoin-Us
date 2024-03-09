package org.thisdote.innerjoinus.studygroup_member.command.service;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.thisdote.innerjoinus.studygroup_member.command.entity.StudyGroupMemberEntity;
import org.thisdote.innerjoinus.studygroup_member.command.repository.StudyGroupMemberCommandRepository;
import org.thisdote.innerjoinus.studygroup_member.dto.StudyGroupMemberDTO;

import java.util.Date;


@Service
public class StudyGroupMemberCommandServiceImpl implements StudyGroupMemberCommandService{

    private final ModelMapper modelMapper;
    private final StudyGroupMemberCommandRepository studyGroupMemberCommandRepository;

    @Autowired
    public StudyGroupMemberCommandServiceImpl(ModelMapper modelMapper,
                                              StudyGroupMemberCommandRepository studyGroupMemberCommandRepository) {
        this.modelMapper = modelMapper;
        this.studyGroupMemberCommandRepository = studyGroupMemberCommandRepository;
    }

    @Transactional
    @Override
    public StudyGroupMemberDTO registStudyGroupMember(StudyGroupMemberDTO newStudyGroupMember) {

        Date enrollDate = new Date();
        newStudyGroupMember.setStudyGroupRegistDate(enrollDate);
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        StudyGroupMemberEntity studyGroupMemberEntity = modelMapper.map(newStudyGroupMember, StudyGroupMemberEntity.class);
        StudyGroupMemberEntity entityFromDB = studyGroupMemberCommandRepository.save(studyGroupMemberEntity);
        return modelMapper.map(entityFromDB, StudyGroupMemberDTO.class);
    }

    @Transactional
    @Override
    public void modifyStudyGroupMemberRole(StudyGroupMemberDTO modifyStudyGroupMember) {
        StudyGroupMemberEntity foundStudyGroupMember =
                studyGroupMemberCommandRepository
                        .findById(modifyStudyGroupMember.getStudyGroupMemberId())
                        .orElseThrow(IllegalArgumentException::new);
        foundStudyGroupMember.setStudyGroupRole(0);
    }

    @Transactional
    @Override
    public String deleteStudyGroupMemberId(int studyGroupMemberId) {
        studyGroupMemberCommandRepository.deleteById(studyGroupMemberId);
        return "삭제되었습니다.";
    }

}
