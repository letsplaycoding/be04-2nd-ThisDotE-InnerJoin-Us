package org.thisdote.innerjoinus.studygroup.dto;

import lombok.*;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class StudyGroupDTO {

    private int studyGroupId;
    private int studyGroupType;
    private Date studyGroupCreatedDate;
    private int studyGroupMemberCount;
    private int studyGroupActivationStatus;
    private Date studyGroupStudyTime;
    private String studyGroupContent;
    private int studyGroupDeleteStatus;

}
