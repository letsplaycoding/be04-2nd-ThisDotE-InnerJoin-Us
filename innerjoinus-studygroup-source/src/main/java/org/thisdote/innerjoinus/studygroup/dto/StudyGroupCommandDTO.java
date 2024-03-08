package org.thisdote.innerjoinus.studygroup.dto;

import lombok.*;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class StudyGroupCommandDTO {

    private int studygroupId;
    private int studygroupType;
    private Date studygroupCreateDate;
    private int studygroupMemberCount;
    private int studygroupActivationStatus;
    private Date studygroupStudyTime;
    private String studygroupContent;
    private int studygroupDeleteStatus;

}
