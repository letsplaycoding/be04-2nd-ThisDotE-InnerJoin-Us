package org.thisdote.innerjoinus.articlereply.article.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.thisdote.innerjoinus.articlereply.article.service.ArticleService;
import org.thisdote.innerjoinus.articlereply.article.vo.ArticleVO;

@RestController
@RequestMapping("/")
public class ArticleController {
    private ArticleVO articleVO;
    private ArticleService articleService;
    private ModelMapper modelMapper;

    @Autowired
    public ArticleController(ArticleVO articleVO, ArticleService articleService, ModelMapper modelMapper) {
        this.articleVO = articleVO;
        this.articleService = articleService;
        this.modelMapper = modelMapper;
    }


}
