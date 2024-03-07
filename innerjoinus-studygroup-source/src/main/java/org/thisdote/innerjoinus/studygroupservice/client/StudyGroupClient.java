package org.thisdote.innerjoinus.studygroupservice.client;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name="swcamp-innerjoinus-{name}", url="localhost:8000")
public interface StudyGroupClient {

}
