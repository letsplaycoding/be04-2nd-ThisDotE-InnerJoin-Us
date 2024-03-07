package org.thisdote.innerjoinus.articlereply.reply.query.service;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.thisdote.communityfordevelopers.reply.dto.ReplyDTO;

import java.util.List;

@Service
public class ReplyService {

    private final SqlSessionTemplate sqlSession;

    @Autowired
    public ReplyService(SqlSessionTemplate sqlSession) {
        this.sqlSession = sqlSession;
    }

    public List<ReplyDTO> findAllReply() {
        return sqlSession.getMapper(ReplyMapper.class).selectAllReply();
    }

    public List<ReplyDTO> selectReplyByUser(int userCode) {
        return sqlSession.getMapper(ReplyMapper.class).selectReplyByUser(userCode);
    }
}
