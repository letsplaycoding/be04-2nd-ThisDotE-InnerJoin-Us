package org.thisdote.innerjoinus.articlereply.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.thisdote.innerjoinus.articlereply.article.command.vo.ResponseUser;

import java.util.List;

@FeignClient(name = "INNERJOINUS-USER", url = "localhost:8000")
public interface UserClient {
    @GetMapping("/user/users/all")
    List<ResponseUser> getAllUser();
}
