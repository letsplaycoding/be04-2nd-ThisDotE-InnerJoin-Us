package org.thisdote.innerjoinus.articlereply.reply.command.service;

import org.springframework.stereotype.Service;
import org.thisdote.innerjoinus.articlereply.reply.dto.ReplyDTO;

public interface ReplyCommandService {

    ReplyDTO registReply(ReplyDTO replyDTO);
}
