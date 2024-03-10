package org.thisdote.innerjoinus.user.vo;

import lombok.*;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class ResponseUserReply {
    private Integer userCode;
    private String userId;
    private String userPassword;
    private Date userBirthday;
    private String userPhone;
    private String userEmail;
    private ResponseReply replyList;
}
