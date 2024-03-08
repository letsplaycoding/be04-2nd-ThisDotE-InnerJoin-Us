package org.thisdote.innerjoinus.studygroupservice.command.service;

import org.springframework.stereotype.Service;
import org.thisdote.innerjoinus.studygroupservice.dto.StudyGroupCommandDTO;


@Service
public interface StudyGroupCommandService {


    void updateStudyGroup(StudyGroupCommandDTO studyGroupCommandDTO);

    void removeStudyGroup(StudyGroupCommandDTO studyGroupCommandDTO);

    void insertStudygroup(StudyGroupCommandDTO studyGroupCommandDTO);
}
