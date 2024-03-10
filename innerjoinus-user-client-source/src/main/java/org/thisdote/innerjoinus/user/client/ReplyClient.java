package org.thisdote.innerjoinus.user.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.thisdote.innerjoinus.user.vo.ResponseReply;

@FeignClient(name="INNERJOINUS-ARTICLEREPLY", url = "localhost:8000")
public interface ReplyClient {
    @GetMapping("/article-reply/reply/select/{replyId}")
    ResponseReply getAllReply(@PathVariable("replyId") int replyId);
}
