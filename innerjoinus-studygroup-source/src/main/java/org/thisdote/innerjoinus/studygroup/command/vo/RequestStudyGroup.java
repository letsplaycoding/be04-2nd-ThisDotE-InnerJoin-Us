package org.thisdote.innerjoinus.studygroup.command.vo;

import lombok.*;
import org.springframework.stereotype.Component;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Component
public class RequestStudyGroup {
    private int studygroupType;
    private java.util.Date studygroupCreateDate;
    private int studygroupMemberCount;
    private int studygroupActivationStatus;
    private java.util.Date studygroupStudyTime;
    private String studygroupContent;
    private int studygroupDeleteStatus;
}
