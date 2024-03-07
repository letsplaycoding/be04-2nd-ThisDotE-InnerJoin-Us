package org.thisdote.user.dto;

import org.thisdote.communityfordevelopers.studygroup_member.dto.StudyGroupMemberDTO;

import java.util.Date;

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
    private int userResignStatus;
    private StudyGroupMemberDTO studyGroupMemberDTO;

    public UserDTO() {
    }

    public UserDTO(int userCode, String userId, String userPassword, Date userBirthday, String userPhone, String userEmail, int userStudygroupStatus, Date userRegistDate, Date userInfoUpdateDate, int userGrade, int userResignStatus) {
        this.userCode = userCode;
        this.userId = userId;
        this.userPassword = userPassword;
        this.userBirthday = userBirthday;
        this.userPhone = userPhone;
        this.userEmail = userEmail;
        this.userStudyGroupStatus = userStudygroupStatus;
        this.userRegistDate = userRegistDate;
        this.userInfoUpdateDate = userInfoUpdateDate;
        this.userGrade = userGrade;
        this.userResignStatus = userResignStatus;
    }

    public UserDTO(int userCode, String userId, String userPassword, Date userBirthday, String userPhone, String userEmail, int userStudyGroupStatus, Date userRegistDate, Date userInfoUpdateDate, int userGrade, int userResignStatus, StudyGroupMemberDTO studyGroupMemberDTO) {
        this.userCode = userCode;
        this.userId = userId;
        this.userPassword = userPassword;
        this.userBirthday = userBirthday;
        this.userPhone = userPhone;
        this.userEmail = userEmail;
        this.userStudyGroupStatus = userStudyGroupStatus;
        this.userRegistDate = userRegistDate;
        this.userInfoUpdateDate = userInfoUpdateDate;
        this.userGrade = userGrade;
        this.userResignStatus = userResignStatus;
        this.studyGroupMemberDTO = studyGroupMemberDTO;
    }

    public int getUserCode() {
        return userCode;
    }
    public String getUserId() {
        return userId;
    }
    public String getUserPassword() {
        return userPassword;
    }
    public Date getUserBirthday() {
        return userBirthday;
    }
    public String getUserPhone() {
        return userPhone;
    }
    public String getUserEmail() {
        return userEmail;
    }
    public int getUserStudyGroupStatus() {
        return userStudyGroupStatus;
    }
    public Date getUserRegistDate() {
        return userRegistDate;
    }
    public Date getUserInfoUpdateDate() {
        return userInfoUpdateDate;
    }
    public int getUserGrade() {
        return userGrade;
    }

    public int getUserResignStatus() {
        return userResignStatus;
    }

    public void setUserCode(int userCode) {
        this.userCode = userCode;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public void setUserBirthday(Date userBirthday) {
        this.userBirthday = userBirthday;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public void setUserStudyGroupStatus(int userStudyGroupStatus) {
        this.userStudyGroupStatus = userStudyGroupStatus;
    }

    public void setUserRegistDate(Date userRegistDate) {
        this.userRegistDate = userRegistDate;
    }

    public void setUserInfoUpdateDate(Date userInfoUpdateDate) {
        this.userInfoUpdateDate = userInfoUpdateDate;
    }

    public void setUserGrade(int userGrade) {
        this.userGrade = userGrade;
    }

    public void setUserResignStatus(int userResignStatus) {
        this.userResignStatus = userResignStatus;
    }

    public void setStudyGroupMemberDTO(StudyGroupMemberDTO studyGroupMemberDTO) {
        this.studyGroupMemberDTO = studyGroupMemberDTO;
    }

    public StudyGroupMemberDTO getStudyGroupMemberDTO() {
        return studyGroupMemberDTO;
    }

    @Override
    public String toString() {
        return "UserDTO{" +
                "userCode=" + userCode +
                ", userId='" + userId + '\'' +
                ", userPassword='" + userPassword + '\'' +
                ", userBirthday=" + userBirthday +
                ", userPhone='" + userPhone + '\'' +
                ", userEmail='" + userEmail + '\'' +
                ", userStudyGroupStatus=" + userStudyGroupStatus +
                ", userRegistDate=" + userRegistDate +
                ", userInfoUpdateDate=" + userInfoUpdateDate +
                ", userGrade=" + userGrade +
                ", userResignStatus=" + userResignStatus +
                ", studyGroupMemberDTO=" + studyGroupMemberDTO +
                '}';
    }
}
