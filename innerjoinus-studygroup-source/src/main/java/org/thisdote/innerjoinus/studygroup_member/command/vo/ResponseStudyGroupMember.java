package org.thisdote.innerjoinus.studygroup_member.command.vo;


import lombok.*;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class ResponseStudyGroupMember {

    private int studyGroupId;
    private int studyGroupRole;
    private Date studyGroupRegistDate;
    private int userCode;

}
