package org.thisdote.innerjoinus.articlereply.article.query.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.thisdote.innerjoinus.articlereply.article.dto.ArticleDTO;
import org.thisdote.innerjoinus.articlereply.article.query.service.ArticleService;
import org.thisdote.innerjoinus.articlereply.article.query.service.ArticleServiceImpl;
import org.thisdote.innerjoinus.articlereply.article.query.vo.ResponseArticle;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/")
public class ArticleController {
    private ArticleService articleService;

    @Autowired
    public ArticleController(ArticleService articleService) {
        this.articleService = articleService;
    }

    @GetMapping("/select")
    public ResponseEntity<List<ResponseArticle>> selectAllArticle(){
        List<ArticleDTO> articleDTOList = articleService.selectAllArticle();
        List<ResponseArticle> returnValue = articleDTOToTesponseOrder(articleDTOList);

        return ResponseEntity.status(HttpStatus.OK).body(returnValue);
    }

    private List<ResponseArticle> articleDTOToTesponseOrder(List<ArticleDTO> articleDTOList) {
        List<ResponseArticle> responseArticles = new ArrayList<>();
        for (ArticleDTO articleDTO : articleDTOList) {
            ResponseArticle responseArticle = new ResponseArticle();
            responseArticle.setArticleId(articleDTO.getArticleId());
            responseArticle.setArticleTitle(articleDTO.getArticleTitle());
            responseArticle.setArticleContent(articleDTO.getArticleContent());
            responseArticle.setArticleCategory(articleDTO.getArticleCategory());
            responseArticle.setArticleCreateDate(articleDTO.getArticleCreateDate());
            responseArticle.setArticleLastUpdateDate(articleDTO.getArticleLastUpdateDate());
            responseArticle.setArticleViewCount(articleDTO.getArticleViewCount());
            responseArticle.setArticleLikeCount(articleDTO.getArticleLikeCount());
            responseArticle.setArticleReplyCount(articleDTO.getArticleReplyCount());
            responseArticle.setArticleReportStatus(articleDTO.getArticleReportStatus());
            responseArticle.setStudygroupMemberMaxCount(articleDTO.getStudygroupMemberMaxCount());
            responseArticle.setStudygroupRecruitmentDeadline(articleDTO.getStudygroupRecruitmentDeadline());
            responseArticle.setArticleQuestionCategory(articleDTO.getArticleQuestionCategory());
            responseArticle.setUserCode(articleDTO.getUserCode());
            responseArticle.setStudygroupId(articleDTO.getStudygroupId());
            responseArticle.setStudygroupCurrentMemberCount(articleDTO.getStudygroupCurrentMemberCount());
            responseArticle.setStudygroupPendingMemberCount(articleDTO.getStudygroupPendingMemberCount());
            responseArticle.setArticleDeleteStatus(articleDTO.getArticleDeleteStatus());

            responseArticles.add(responseArticle);
        }

        return responseArticles;
    }
}
