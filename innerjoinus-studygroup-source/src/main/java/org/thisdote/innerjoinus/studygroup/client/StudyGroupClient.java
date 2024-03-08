package org.thisdote.innerjoinus.studygroup.client;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name="swcamp-innerjoinus-studygroup", url="localhost:8888")
public interface StudyGroupClient {

}
