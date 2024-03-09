package org.thisdote.innerjoinus.studygroup_member.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.thisdote.innerjoinus.studygroup_member.query.vo.ResponseStudyGroupMember;

import java.util.List;

@FeignClient(name = "innerjoinus-studygroup-member", url = "localhost:8888")
public class StudyGroupMemberServiceClient {

}
