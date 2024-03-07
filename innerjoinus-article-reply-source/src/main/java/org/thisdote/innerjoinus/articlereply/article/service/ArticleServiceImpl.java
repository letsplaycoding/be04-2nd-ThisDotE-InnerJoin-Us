package org.thisdote.innerjoinus.articlereply.article.service;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.thisdote.innerjoinus.articlereply.article.repository.ArticleRepository;

@Transactional
@Service
public abstract class ArticleServiceImpl implements ArticleService {
    private ArticleRepository articleRepository;
    private ModelMapper modelMapper;

}
