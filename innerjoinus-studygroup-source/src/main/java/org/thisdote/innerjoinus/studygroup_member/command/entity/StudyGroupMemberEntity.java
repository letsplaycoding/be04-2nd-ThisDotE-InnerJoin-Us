package org.thisdote.innerjoinus.studygroup_member.command.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "studygroup_member")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class StudyGroupMemberEntity implements Serializable {

    @Id
    @Column(name = "studygroup_member_id")
    private Integer studyGroupMemberId;

    @Column(name = "studygroup_id")
    private Integer studyGroupId;

    @Column(name = "studygroup_role")
    private Integer studyGroupRole;     // 0 - 스터디원, 1 - 스터디장

    @Column(name = "studygroup_regist_date")
    private Date studyGroupRegistDate;

    @Column(name = "user_code")
    private Integer userCode;

}
