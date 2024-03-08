package org.thisdote.innerjoinus.articlereply.reply.command.service;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.thisdote.innerjoinus.articlereply.reply.command.aggregate.ReplyCommandEntity;
import org.thisdote.innerjoinus.articlereply.reply.command.repository.ReplyCommandRepository;
import org.thisdote.innerjoinus.articlereply.reply.dto.ReplyDTO;

import java.util.Date;

@Service
public class ReplyCommandServiceImpl implements ReplyCommandService{

    private final ModelMapper mapper;
    private final ReplyCommandRepository replyCommandRepository;

    @Autowired
    public ReplyCommandServiceImpl(ModelMapper mapper, ReplyCommandRepository replyCommandRepository) {
        this.mapper = mapper;
        this.replyCommandRepository = replyCommandRepository;
    }

    @Transactional
    @Override
    public ReplyDTO registReply(ReplyDTO replyDTO) {
        Date createdDate = new Date();

        // front 단에서 건들 수 없으나 내부적으로 수정되어야 하는 값들 수정
        replyDTO.setReplyReportStatus(0);
        replyDTO.setReplyCreatedDate(createdDate);
        replyDTO.setReplyLastUpdateDate(createdDate);
        replyDTO.setReplyLikeCount(0);
        replyDTO.setReplyDeleteStatus(0);

        mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        ReplyCommandEntity replyCommandEntity = mapper.map(replyDTO, ReplyCommandEntity.class);


        replyCommandRepository.save(replyCommandEntity);
        return replyDTO;

    }

    @Transactional
    @Override
    public ReplyDTO modifyReply(ReplyDTO inputModifyReplyDTO) {

        try {
            ReplyCommandEntity returnedReply = replyCommandRepository.findById(inputModifyReplyDTO.getReplyId()).get();
            mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
            ReplyDTO modifyDTO = mapper.map(returnedReply, ReplyDTO.class);

            // reply_last_update_date: front 단에서 건들 수 없으나 내부적으로 수정되어야 하는 값
            Date updatedDate = new Date();
            modifyDTO.setReplyLastUpdateDate(updatedDate);

            // reply_content: front 단에서 받아와 수정해야 하는 값
            modifyDTO.setReplyContent(inputModifyReplyDTO.getReplyContent());

            // 수정된 DTO를 entity로 바꿔 DB에 save
            replyCommandRepository.save(mapper.map(modifyDTO, ReplyCommandEntity.class));
            return modifyDTO;

        } catch (Exception e) {
            // 존재하지 않는 reply_id 가 입력됐을때
            return null;
        }
    }

    @Transactional
    @Override
    public String deleteReply(ReplyDTO replyDTO) {
        ReplyCommandEntity reply = replyCommandRepository.findById(replyDTO.getReplyId()).get();
        if (reply.getReplyDeleteStatus() == 1) {    // 1이 삭제, 0이 미삭제
            return "이미 삭제된 댓글입니다.";
        } else {
            reply.setReplyDeleteStatus(replyDTO.getReplyDeleteStatus());
            return "댓글이 삭제되었습니다.";
        }
    }
}
