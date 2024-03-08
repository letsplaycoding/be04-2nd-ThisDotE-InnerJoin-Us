package org.thisdote.innerjoinus.studygroup.command.vo;

import lombok.*;
import org.springframework.stereotype.Component;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
@Component
public class ResponseStudyGroup {
    private int studygroupType;
    private java.util.Date studygroupCreateDate;
    private int studygroupMemberCount;
    private int studygroupActivationStatus;
    private java.util.Date studygroupStudyTime;
    private String studygroupContent;
    private int studygroupDeleteStatus;

}
