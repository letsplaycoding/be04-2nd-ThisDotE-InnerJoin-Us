package org.thisdote.innerjoinus.studygroup_member.client;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "swcamp-studygroup_member", url = "localhost:8080")
public class StudyGroupMemberServiceClient {

}
