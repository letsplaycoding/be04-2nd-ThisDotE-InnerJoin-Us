package org.thisdote.innerjoinus.studygroup.command.service;

import org.thisdote.innerjoinus.studygroup.dto.StudyGroupCommandDTO;

public interface StudyGroupCommandService {


    void updateStudyGroup(StudyGroupCommandDTO studyGroupCommandDTO);

    void removeStudyGroup(StudyGroupCommandDTO studyGroupCommandDTO);

    StudyGroupCommandDTO insertStudygroup(StudyGroupCommandDTO studyGroupCommandDTO);
}
