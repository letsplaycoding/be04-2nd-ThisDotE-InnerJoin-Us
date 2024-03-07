package org.thisdote.innerjoinus.articlereply.article.command.vo;

import lombok.Data;
import lombok.Value;
import org.springframework.stereotype.Component;

@Data
@Component
public class RequestDeleteArticle {
    private int articleId;
    private int articleDeleteStatus;
}
