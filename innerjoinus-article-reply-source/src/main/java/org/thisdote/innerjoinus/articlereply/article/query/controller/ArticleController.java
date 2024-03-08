package org.thisdote.innerjoinus.articlereply.article.query.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.thisdote.innerjoinus.articlereply.article.query.vo.ResponseArticleByUser;
import org.thisdote.innerjoinus.articlereply.article.dto.ArticleDTO;
import org.thisdote.innerjoinus.articlereply.article.query.service.ArticleService;
import org.thisdote.innerjoinus.articlereply.article.query.vo.ResponseArticle;
import org.thisdote.innerjoinus.articlereply.article.query.vo.ResponseQuestionArticle;
import org.thisdote.innerjoinus.articlereply.article.query.vo.ResponseStudyArticleInfo;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/")
public class ArticleController {
    private ArticleService articleService;

    private final ModelMapper mapper;

    @Autowired
    public ArticleController(ArticleService articleService, ModelMapper mapper) {
        this.articleService = articleService;
        this.mapper = mapper;
    }

    @GetMapping("/select")
    public ResponseEntity<List<ResponseArticle>> selectAllArticle(){
        List<ArticleDTO> articleDTOList = articleService.selectAllArticle();
        List<ResponseArticle> returnValue = articleDTOToTesponseOrder(articleDTOList);

        return ResponseEntity.status(HttpStatus.OK).body(returnValue);
    }

    @GetMapping("/question")
    public ResponseEntity<List<ResponseQuestionArticle>> selectAllQuestionArticle(){
        List<ArticleDTO> articleDTOList = articleService.selectAllQuestionArticle();
        List<ResponseQuestionArticle> returnValue = new ArrayList<>();

        if (articleDTOList != null) {
            returnValue = articleDTOList.stream().map(ArticleDTO -> mapper.map(ArticleDTO, ResponseQuestionArticle.class)).toList();
        }

        return ResponseEntity.status(HttpStatus.OK).body(returnValue);
    }

    @GetMapping("/select/article/{user_code}")
    public ResponseEntity<List<ResponseArticleByUser>> selectArticleByUser(@PathVariable("user_code") int user_code){
        List<ArticleDTO> articleDTOList = articleService.selectArticleByUser(user_code);
        List<ResponseArticleByUser> returnValue = new ArrayList<>();

        if (articleDTOList != null) {
            returnValue = articleDTOList.stream().map(ArticleDTO -> mapper.map(ArticleDTO, ResponseArticleByUser.class)).toList();
        }

        return ResponseEntity.status(HttpStatus.OK).body(returnValue);
    }

    @GetMapping("/select/study/{articleId}/{studyCate}")
    public ResponseEntity<List<ResponseStudyArticleInfo>> selectStudyArticleInfo
            (@PathVariable("articleId") int article_id, @PathVariable("studyCate") int study_cate){
        List<ArticleDTO> articleDTOList = articleService.selectStudyArticleInfo(article_id, study_cate);
        List<ResponseStudyArticleInfo> returnValue = articleAndReplyDTOToTesponseOrder(articleDTOList);

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

    private List<ResponseStudyArticleInfo> articleAndReplyDTOToTesponseOrder(List<ArticleDTO> articleDTOList) {
        List<ResponseStudyArticleInfo> responseArticles = new ArrayList<>();
        for (ArticleDTO articleDTO : articleDTOList) {
            ResponseStudyArticleInfo responseArticle = new ResponseStudyArticleInfo();

            responseArticle.setArticleId(articleDTO.getArticleId());
            responseArticle.setArticleTitle(articleDTO.getArticleTitle());
            responseArticle.setArticleContent(articleDTO.getArticleContent());
            responseArticle.setArticleCategory(articleDTO.getArticleCategory());
            responseArticle.setArticleLastUpdateDate(articleDTO.getArticleLastUpdateDate());
            responseArticle.setArticleViewCount(articleDTO.getArticleViewCount());
            responseArticle.setArticleLikeCount(articleDTO.getArticleLikeCount());
            responseArticle.setArticleReplyCount(articleDTO.getArticleReplyCount());
            responseArticle.setStudygroupMemberMaxCount(articleDTO.getStudygroupMemberMaxCount());
            responseArticle.setStudygroupRecruitmentDeadline(articleDTO.getStudygroupRecruitmentDeadline());
            responseArticle.setStudygroupCurrentMemberCount(articleDTO.getStudygroupCurrentMemberCount());
            responseArticle.setStudygroupPendingMemberCount(articleDTO.getStudygroupPendingMemberCount());
            responseArticle.setReplyDTOList(articleDTO.getReplyDTOList());

            responseArticles.add(responseArticle);
        }
        return responseArticles;
    }
}
