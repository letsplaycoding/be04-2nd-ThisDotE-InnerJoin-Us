package org.thisdote.innerjoinus.articlereply.reply.command.vo;

import lombok.Data;

import java.util.Date;

@Data
public class ResponseModifyReply {
    private String replyContent;
    private Date replyCreatedDate;
    private Date replyLastUpdateDate;
    private int replyLikeCount;
}
