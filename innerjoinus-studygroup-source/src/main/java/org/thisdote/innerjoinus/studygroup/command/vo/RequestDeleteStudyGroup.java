package org.thisdote.innerjoinus.studygroup.command.vo;

import lombok.*;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class RequestDeleteStudyGroup {
    private int studygroupId;
    private int studygroupType;
    private int studygroupMemberCount;
    private Date studygroupCreateDate;
    private int studygroupActivationStatus;
    private Date studygroupStudyTime;
    private String studygroupContent;
    private int studygroupDeleteStatus;
}
