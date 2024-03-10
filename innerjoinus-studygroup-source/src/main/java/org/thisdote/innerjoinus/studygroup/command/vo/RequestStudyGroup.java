package org.thisdote.innerjoinus.studygroup.command.vo;

import lombok.*;
import org.springframework.stereotype.Component;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Component
public class RequestStudyGroup {
    private int studygroupType;
    private Date studygroupCreateDate;
    private int studygroupMemberCount;
    private int studygroupActivationStatus;
    private Date studygroupStudyTime;
    private String studygroupContent;
    private int studygroupDeleteStatus;
}
