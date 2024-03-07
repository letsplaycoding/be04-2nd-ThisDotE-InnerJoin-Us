package org.thisdote.innerjoinus.articlereply.article.command.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.thisdote.innerjoinus.articlereply.article.command.aggregate.ArticleEntity;

public interface ArticleRepository extends JpaRepository<ArticleEntity, Integer> {

}
