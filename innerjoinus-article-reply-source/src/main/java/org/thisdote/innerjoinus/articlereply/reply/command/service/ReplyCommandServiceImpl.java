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
}
