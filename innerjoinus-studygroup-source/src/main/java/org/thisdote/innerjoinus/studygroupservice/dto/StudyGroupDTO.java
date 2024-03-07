package org.thisdote.innerjoinus.studygroupservice.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class StudyGroupDTO {
    private int studygroupId;
    private int studygroupType;
    private java.util.Date studygroupCreateDate;
    private int studygroupMemberCount;
    private int studygroupActivationStatus;
    private java.util.Date studygroupStudyTime;
    private String studygroupContent;
    private int studygroupDeleteStatus;

}
