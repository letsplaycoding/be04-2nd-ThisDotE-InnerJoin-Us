package org.thisdote.innerjoinus.studygroup.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.thisdote.innerjoinus.studygroup.command.vo.ResponseStudyGroup;

import java.util.List;

@FeignClient(name="innerjoinus-studygroup-member", url="localhost:8000")
public interface StudyGroupClient {

}
