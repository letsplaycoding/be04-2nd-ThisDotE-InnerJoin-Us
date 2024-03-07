package org.thisdote.innerjoinus.studygroup_member.query.vo;

import lombok.*;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class ResponseStudyGroupMember {
    private int studyGroupRole;
    private Date studyGroupRegistDate;

}
