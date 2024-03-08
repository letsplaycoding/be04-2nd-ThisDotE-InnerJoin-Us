package org.thisdote.innerjoinus.articlereply.article.command.service;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.thisdote.innerjoinus.articlereply.article.command.aggregate.ArticleEntity;
import org.thisdote.innerjoinus.articlereply.article.command.repository.CommandArticleRepository;
import org.thisdote.innerjoinus.articlereply.article.command.vo.ResponseUserCode;
import org.thisdote.innerjoinus.articlereply.article.command.vo.ResponseUserCodeArticle;
import org.thisdote.innerjoinus.articlereply.article.dto.ArticleDTO;
import org.thisdote.innerjoinus.articlereply.client.ArticleServiceClient;

import java.util.Date;
import java.util.List;

@Service
public class CommandArticleServiceImpl implements CommandArticleService {
    private final ModelMapper mapper;
    private final CommandArticleRepository commandArticleRepository;
    private final ArticleServiceClient articleServiceClient;

    @Autowired
    public CommandArticleServiceImpl(ModelMapper mapper
            , CommandArticleRepository commandArticleRepository, ArticleServiceClient articleServiceClient) {
        this.mapper = mapper;
        this.commandArticleRepository = commandArticleRepository;
        this.articleServiceClient = articleServiceClient;
    }

    @Transactional
    public ArticleDTO registArticle(ArticleDTO newArticle){
        newArticle.setArticleCreateDate(new Date());
        newArticle.setArticleLastUpdateDate(new Date());
        mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        commandArticleRepository.save(mapper.map(newArticle, ArticleEntity.class));

        return mapper.map(newArticle, ArticleDTO.class);
    }

    @Transactional
    @Override
    public String deleteArticle(ArticleDTO articleDTO) {
        ArticleEntity article = commandArticleRepository.findById(articleDTO.getArticleId()).get();

        if(article.getArticleDeleteStatus() == 1){
            return "이미 삭제된 게시글입니다.";
        } else{
            article.setArticleDeleteStatus(articleDTO.getArticleDeleteStatus());
            return "게시글이 삭제 되었습니다.";
        }
    }

    @Transactional
    @Override
    public ArticleDTO modifyArticle(ArticleDTO articleDTO) {
        ArticleEntity article = commandArticleRepository.findById(articleDTO.getArticleId()).get();
        article.setArticleTitle(articleDTO.getArticleTitle());
        article.setArticleContent(articleDTO.getArticleContent());
        article.setArticleLastUpdateDate(new Date());

        return mapper.map(article, ArticleDTO.class);
    }

    @Override
    public ArticleDTO getUserCodeArticle(int articleId) {
        ArticleEntity article = commandArticleRepository.findById(articleId).get();
        ArticleDTO articleDTO = mapper.map(article, ArticleDTO.class);

        List<ResponseUserCode> articleList = articleServiceClient.getUsers(articleDTO.getUserCodes());
        articleDTO.setUserCodes(articleList);
        return articleDTO;
    }
}
