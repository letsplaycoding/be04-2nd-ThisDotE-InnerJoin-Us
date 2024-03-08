package org.thisdote.innerjoinus.studygroup.command.vo;

import lombok.*;
import org.springframework.stereotype.Component;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
@Component
public class ResponseStudyGroup {
    private int studygroupType;
    private Date studygroupCreateDate;
    private int studygroupMemberCount;
    private int studygroupActivationStatus;
    private Date studygroupStudyTime;
    private String studygroupContent;
    private int studygroupDeleteStatus;

}
