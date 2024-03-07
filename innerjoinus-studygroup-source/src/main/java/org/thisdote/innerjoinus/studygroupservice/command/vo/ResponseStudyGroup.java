package org.thisdote.innerjoinus.studygroupservice.command.vo;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class ResponseStudyGroup {
    private int studygroupType;
    private java.util.Date studygroupCreateDate;
    private int studygroupMemberCount;
    private int studygroupActivationStatus;
    private java.util.Date studygroupStudyTime;
    private String studygroupContent;
    private int studygroupDeleteStatus;

}