package org.thisdote.innerjoinus.articlereply.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "INNERJOINUS-USER", url = "localhost:8000")
public class UserClient {
    @GetMapping()
}
