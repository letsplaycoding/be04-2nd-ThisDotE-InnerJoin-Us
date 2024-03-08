package org.thisdote.innerjoinus.articlereply.reply.command.vo;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.Date;

@Data
public class ResponseRegistReply {
//    private int replyId;                // pk..
    private int replyReportStatus;
    private String replyContent;
    private Date replyCreatedDate;
    private Date replyLastUpdateDate;
    private int replyLikeCount;
    private int userCode;               // fk..
    private int articleId;              // fk..
    private int replyDeleteStatus;
}
