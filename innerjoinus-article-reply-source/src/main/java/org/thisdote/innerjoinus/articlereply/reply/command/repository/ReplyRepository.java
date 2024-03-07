package org.thisdote.innerjoinus.articlereply.reply.command.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.thisdote.communityfordevelopers.reply.command.entity.Reply;

public interface ReplyRepository extends JpaRepository<Reply, Integer> {

}
