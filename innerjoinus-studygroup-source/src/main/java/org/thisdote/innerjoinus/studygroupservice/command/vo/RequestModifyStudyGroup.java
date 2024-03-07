package org.thisdote.innerjoinus.studygroupservice.command.vo;

import lombok.*;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class RequestModifyStudyGroup {
    private int studygroupType;
    private int studygroupMemberCount;
    private int studygroupActivationStatus;
    private Date studygroupStudyTime;
    private String studygroupContent;
}
