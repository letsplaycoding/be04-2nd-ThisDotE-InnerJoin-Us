package org.thisdote.innerjoinus.articlereply.reply.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.thisdote.innerjoinus.articlereply.reply.aggregate.ReplyEntity;

public interface ReplyRepository extends JpaRepository<ReplyEntity, Integer> {
}
