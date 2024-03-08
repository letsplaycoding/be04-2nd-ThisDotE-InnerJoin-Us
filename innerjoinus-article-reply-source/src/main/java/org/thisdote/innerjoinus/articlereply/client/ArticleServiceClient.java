package org.thisdote.innerjoinus.articlereply.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.thisdote.innerjoinus.articlereply.article.command.vo.ResponseUserCode;

import java.util.List;

@FeignClient(name="innerjoinus-articlereply", url="localhost:9000")
public interface ArticleServiceClient {
    @GetMapping("/user/{userCode}")
    List<ResponseUserCode> getUsers(@PathVariable("userCode") int userCode);

    List<ResponseUserCode> getUsers(List<ResponseUserCode> userCodes);
}
