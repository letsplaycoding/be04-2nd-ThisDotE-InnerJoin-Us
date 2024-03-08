package org.thisdote.innerjoinus.studygroup.query.vo;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class ResponseStudyGroup {
    private int studygroupType;
    private String studygroupCreateDate;
    private int studygroupMemberCount;
    private int studygroupActivationStatus;
    private String studygroupStudyTime;
    private String studygroupContent;
    private int studygroupDeleteStatus;
}
