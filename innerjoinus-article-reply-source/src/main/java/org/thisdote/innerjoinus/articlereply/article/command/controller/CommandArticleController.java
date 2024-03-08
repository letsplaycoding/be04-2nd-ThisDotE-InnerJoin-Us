package org.thisdote.innerjoinus.articlereply.article.command.controller;

import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.thisdote.innerjoinus.articlereply.article.command.service.CommandArticleService;
import org.thisdote.innerjoinus.articlereply.article.command.vo.*;
import org.thisdote.innerjoinus.articlereply.article.dto.ArticleDTO;

@Slf4j
@RestController
@RequestMapping("/")
public class CommandArticleController {
    private final ModelMapper modelMapper;
    private final CommandArticleService commandArticleService;

    public CommandArticleController(ModelMapper modelMapper, CommandArticleService commandArticleService) {
        this.modelMapper = modelMapper;
        this.commandArticleService = commandArticleService;
    }

    @GetMapping("/regist_article")
    public void registArticle(){}

    @PostMapping("/regist_article")
    public ResponseEntity<ResponseRegistArticle> registArticle(@RequestBody RequestRegistArticle registArticle){
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        ArticleDTO articleDTO = modelMapper.map(registArticle, ArticleDTO.class);
        commandArticleService.registArticle(articleDTO);

        ResponseRegistArticle responseRegistArticle = new ResponseRegistArticle();
        responseRegistArticle.setMessage(articleDTO.getArticleTitle());
        System.out.println("responseRegistArticle = " + responseRegistArticle);
        return  ResponseEntity.status(HttpStatus.CREATED).body(responseRegistArticle);
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

    @GetMapping("/modify_article")
    public void modifyArticle(){}

    @PostMapping("/modify_article")
    public ResponseEntity<ResponseModifyArticle> modifyArticle(@RequestBody RequestModifyArticle modifyArticle){
        ArticleDTO articleDTO = modelMapper.map(modifyArticle, ArticleDTO.class);
        commandArticleService.modifyArticle(articleDTO);

        ResponseModifyArticle responseModifyArticle = new  ResponseModifyArticle();
        responseModifyArticle.setMessage("수정 완료");
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(responseModifyArticle);
    }
}
