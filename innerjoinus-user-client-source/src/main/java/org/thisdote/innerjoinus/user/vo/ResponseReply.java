package org.thisdote.innerjoinus.user.vo;

import lombok.*;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class ResponseReply {
    private int replyReportStatus;
    private String replyContent;
    private Date replyCreateDate;
    private Date replyLastUpdateDate;
    private int replyLikeCount;

}
