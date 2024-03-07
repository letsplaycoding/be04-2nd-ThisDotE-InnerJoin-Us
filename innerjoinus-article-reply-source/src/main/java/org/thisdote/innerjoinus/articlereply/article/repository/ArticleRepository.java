package org.thisdote.innerjoinus.articlereply.article.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.thisdote.innerjoinus.articlereply.article.aggregate.ArticleEntity;

public interface ArticleRepository extends JpaRepository<ArticleEntity, Integer> {

}
