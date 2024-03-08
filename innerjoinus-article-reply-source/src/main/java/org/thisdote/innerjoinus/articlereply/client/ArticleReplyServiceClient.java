package org.thisdote.innerjoinus.articlereply.client;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "innerjoinus")
public interface ArticleReplyServiceClient {

}
