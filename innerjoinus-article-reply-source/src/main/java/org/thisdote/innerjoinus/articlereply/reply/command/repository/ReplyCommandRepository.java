package org.thisdote.innerjoinus.articlereply.reply.command.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.thisdote.innerjoinus.articlereply.reply.command.aggregate.ReplyCommandEntity;

public interface ReplyCommandRepository extends JpaRepository<ReplyCommandEntity, Integer> {
}
