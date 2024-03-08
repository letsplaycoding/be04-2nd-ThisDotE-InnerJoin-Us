package org.thisdote.innerjoinus.articlereply.reply.query.repository;

import org.apache.ibatis.annotations.Mapper;
import org.thisdote.innerjoinus.articlereply.reply.dto.ReplyDTO;

import java.util.List;

@Mapper
public interface ReplyMapper {
    List<ReplyDTO> selectAllReply();

    List<ReplyDTO> selectReplyByUser(int userCode);
}
