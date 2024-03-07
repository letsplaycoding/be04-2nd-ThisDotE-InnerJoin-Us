package org.thisdote.innerjoinus.user.dto;

import lombok.Data;

import java.util.Date;

@Data
public class UserDTO {
    private int userCode;
    private String userId;
    private String userPassword;
    private Date userBirthday;
    private String userPhone;
    private String userEmail;
    private int userStudyGroupStatus;
    private Date userRegistDate;
    private Date userInfoUpdateDate;
    private int userGrade;
    private int userResignStatus;       // 0 - 회원, 1 - 탈퇴 회원
    private StudyGroupMemberDTO studyGroupMemberDTO;
}
