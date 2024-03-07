package org.thisdote.innerjoinus.articlereply.article.vo;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class ArticleVO {
    private int articleId;
    private String articleTitle;
    private String articleContent;
    private int articleCategory;
    private String articleCreateDate;
    private String articleLastUpdateDate;
    private int articleViewCount;
    private int articleLikeCount;
    private int articleReplyCount;
    private int articleReportStatus;
    private int studygroupMemberMaxCount;
    private String studygroupRecruitmentDeadline;
    private String articleQuestionCategory;
    private int userCode;
    private int studygroupId;
    private int studygroupCurrentMemberCount;
    private int studygroupPendingMemberCount;
    private int articleDeleteStatus;


}
