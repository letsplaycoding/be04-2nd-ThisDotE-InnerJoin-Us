package org.thisdote.innerjoinus.user.query.vo;

import lombok.Data;

import java.util.Date;

@Data
public class ResponseUser {
    private String userId;
    private Date userBirthday;
    private String userPhone;
    private String userEmail;
    private String userStudygroupStatus;
    private Date userRegistDate;
    private Date userInfoUpdateDate;
    private Integer userGrade;
    private Integer userResignStatus;
}
