package org.thisdote.innerjoinus.articlereply.article.command.controller;

import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.thisdote.innerjoinus.articlereply.article.command.service.CommandArticleService;
import org.thisdote.innerjoinus.articlereply.article.command.vo.RequestDeleteArticle;
import org.thisdote.innerjoinus.articlereply.article.command.vo.ResponseDeleteArticle;
import org.thisdote.innerjoinus.articlereply.article.dto.ArticleDTO;

@Slf4j
@RestController
@RequestMapping("/")
public class ArticleController {
    private final ModelMapper modelMapper;
    private final CommandArticleService commandArticleService;

    public ArticleController(ModelMapper modelMapper, CommandArticleService commandArticleService) {
        this.modelMapper = modelMapper;
        this.commandArticleService = commandArticleService;
    }

    @GetMapping("/delete_article")
    public void deleteArticle(){}

    @PostMapping("/delete_article")
    public ResponseEntity<ResponseDeleteArticle> deleteArticle(@RequestBody RequestDeleteArticle deleteArticle){
        ArticleDTO articleDTO = modelMapper.map(deleteArticle, ArticleDTO.class);
        ResponseDeleteArticle responseDeleteArticle = new ResponseDeleteArticle();

        responseDeleteArticle.setMessage(commandArticleService.deleteArticle(articleDTO));
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(responseDeleteArticle);
    }


}
