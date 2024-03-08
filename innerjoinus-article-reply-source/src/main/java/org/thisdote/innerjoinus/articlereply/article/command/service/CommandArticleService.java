package org.thisdote.innerjoinus.articlereply.article.command.service;

import org.thisdote.innerjoinus.articlereply.article.dto.ArticleDTO;

public interface CommandArticleService {
    String deleteArticle(ArticleDTO articleDTO);

    void modifyArticle(ArticleDTO modifyArticle);

    void registArticle(ArticleDTO articleDTO);
}
