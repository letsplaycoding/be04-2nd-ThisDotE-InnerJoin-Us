package org.thisdote.innerjoinus.studygroup_member.dto;

import lombok.*;
import org.thisdote.innerjoinus.studygroup_member.command.vo.ResponseUser;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class StudyGroupMemberDTO {
    private int studyGroupMemberId;
    private int studyGroupId;
    private int studyGroupRole;     // 0 - 스터디원, 1 - 스터디장
    private Date studyGroupRegistDate;
    private int userCode;
    private ResponseUser userList;
}
