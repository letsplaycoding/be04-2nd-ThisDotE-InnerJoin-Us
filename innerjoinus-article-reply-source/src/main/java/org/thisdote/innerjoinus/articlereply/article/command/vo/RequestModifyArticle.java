package org.thisdote.innerjoinus.articlereply.article.command.vo;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class RequestModifyArticle {
    private int articleId;
    private String articleTitle;
    private String articleContent;
}
