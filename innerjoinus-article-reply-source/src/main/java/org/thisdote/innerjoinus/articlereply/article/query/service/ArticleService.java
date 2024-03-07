package org.thisdote.innerjoinus.articlereply.article.query.service;

import org.thisdote.innerjoinus.articlereply.article.dto.ArticleDTO;

import java.util.List;

public interface ArticleService {
    List<ArticleDTO> selectAllArticle();
    List<ArticleDTO> selectArticleByUser(int userCode);
}
