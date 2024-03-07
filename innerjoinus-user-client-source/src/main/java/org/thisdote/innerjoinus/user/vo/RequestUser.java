package org.thisdote.innerjoinus.user.vo;

import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.Data;
import org.thisdote.innerjoinus.user.dto.StudyGroupMemberDTO;

import java.util.Date;

@Data
public class RequestUser {
    private Integer userCode;
    private String userId;
    private String userPassword;
    private Date userBirthday;
    private String userPhone;
    private String userEmail;
}
