package org.thisdote.innerjoinus.user.dto;

import lombok.Data;

import java.util.Date;

@Data
public class StudyGroupMemberDTO {
    private int studyGroupMemberId;
    private int studyGroupId;
    private int studyGroupRole;     // 0 - 스터디원, 1 - 스터디장
    private Date studyGroupRegistDate;
    private int userCode;
}
