package org.thisdote.innerjoinus.studygroup_member.command.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.thisdote.innerjoinus.studygroup_member.command.entity.StudyGroupMemberEntity;
import org.thisdote.innerjoinus.studygroup_member.command.repository.StudyGroupMemberCommandRepository;
import org.thisdote.innerjoinus.studygroup_member.dto.StudyGroupMemberDTO;

import java.util.List;

@Service
public class StudyGroupMemberCommandService {

    private final ModelMapper modelMapper;
    private final StudyGroupMemberCommandRepository studyGroupMemberCommandRepository;

    @Autowired
    public StudyGroupMemberCommandService(ModelMapper modelMapper,
                                          StudyGroupMemberCommandRepository studyGroupMemberCommandRepository) {
        this.modelMapper = modelMapper;
        this.studyGroupMemberCommandRepository = studyGroupMemberCommandRepository;
    }

    @Transactional
    public void registStudyGroupMember(StudyGroupMemberDTO newStudyGroupMember) {
        studyGroupMemberCommandRepository.save(
                modelMapper.map(newStudyGroupMember, StudyGroupMemberEntity.class)
        );
    }

    @Transactional
    public void modifyStudyGroupMemberRole(StudyGroupMemberDTO modifyStudyGroupMember) {
        StudyGroupMemberEntity foundStudyGroupMember =
                studyGroupMemberCommandRepository
                        .findById(modifyStudyGroupMember.getStudyGroupMemberId())
                        .orElseThrow(IllegalArgumentException::new);
//        foundStudyGroupMember.setStudyGroupRole();
    }
}
