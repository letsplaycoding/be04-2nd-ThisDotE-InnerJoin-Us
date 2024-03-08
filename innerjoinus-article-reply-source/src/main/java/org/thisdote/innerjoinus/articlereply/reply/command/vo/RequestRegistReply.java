package org.thisdote.innerjoinus.articlereply.reply.command.vo;

import lombok.Data;

@Data
public class RequestRegistReply {
    private String replyContent;
    private int userCode;               // fk..
    private int articleId;              // fk..
}
