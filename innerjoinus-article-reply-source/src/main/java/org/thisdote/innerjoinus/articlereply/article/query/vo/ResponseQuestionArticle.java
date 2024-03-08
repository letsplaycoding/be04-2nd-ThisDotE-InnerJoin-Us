package org.thisdote.innerjoinus.articlereply.article.query.vo;

import lombok.Data;

import java.util.Date;

@Data
public class ResponseQuestionArticle {
    private int articleId;
    private String articleTitle;
    private String articleContent;
    private int articleCategory;
    private Date articleCreateDate;
    private int articleViewCount;
    private int articleLikeCount;
    private int articleReplyCount;
    private String articleQuestionCategory;
    private int userCode;

}
