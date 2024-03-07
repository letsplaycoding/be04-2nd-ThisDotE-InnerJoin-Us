package org.thisdote.innerjoinus.articlereply.article.command.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.thisdote.innerjoinus.articlereply.article.command.aggregate.ArticleEntity;
import org.thisdote.innerjoinus.articlereply.article.command.repository.ArticleRepository;
import org.thisdote.innerjoinus.articlereply.article.dto.ArticleDTO;

@Service
public class ArticleService1 {
    private final ModelMapper mapper;
    private final ArticleRepository articleRepository;

    @Autowired
    public ArticleService1(ModelMapper mapper, ArticleRepository articleRepository) {
        this.mapper = mapper;
        this.articleRepository = articleRepository;
    }

    @Transactional
    public void registArticle(ArticleDTO newArticle){
        articleRepository.save(mapper.map(newArticle, ArticleEntity.class));
    }

    @Transactional
    public void deleteArticle(ArticleDTO articleDTO, int articleId) {
        ArticleEntity article = articleRepository.findById(articleId).get();
        ArticleDTO modifyDTO = mapper.map(article, ArticleDTO.class);

        article.setArticleDeleteStatus(articleDTO.getArticleDeleteStatus());
    }

    @Transactional
    public void modifyArticle(ArticleDTO articleDTO) {
        articleRepository.save(mapper.map(articleDTO, ArticleEntity.class));
    }
}
