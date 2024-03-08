package org.thisdote.innerjoinus.articlereply.article.query.vo;

import lombok.Data;
import org.thisdote.innerjoinus.articlereply.reply.dto.ReplyDTO;

import java.util.Date;
import java.util.List;

@Data
public class ResponseStudyArticleInfo {
    private int articleId;
    private String articleTitle;
    private String articleContent;
    private int articleCategory;
    private Date articleLastUpdateDate;
    private int articleViewCount;
    private int articleLikeCount;
    private int articleReplyCount;
    private int studygroupMemberMaxCount;
    private Date studygroupRecruitmentDeadline;
    private int userCode;
    private int studygroupId;
    private int studygroupCurrentMemberCount;
    private int studygroupPendingMemberCount;
    private List<ReplyDTO> replyDTOList;
}
