package org.thisdote.innerjoinus.articlereply.article.command.aggregate;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "article")
@Data
public class ArticleEntity {
    @Id
    @Column(name = "article_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer articleId;
    @Column(name = "article_title")
    private String articleTitle;
    @Column(name = "article_content")
    private String articleContent;
    @Column(name = "article_category")
    private Integer articleCategory;
    @Column(name = "article_create_date")
    private String articleCreateDate;
    @Column(name = "article_last_update_date")
    private String articleLastUpdateDate;
    @Column(name = "article_view_count")
    private Integer articleViewCount;
    @Column(name = "article_like_count")
    private Integer articleLikeCount;
    @Column(name = "article_reply_count")
    private Integer articleReplyCount;
    @Column(name = "article_report_status")
    private Integer articleReportStatus;
    @Column(name = "studygroup_member_max_count")
    private Integer studygroupMemberMaxCount;
    @Column(name = "studygroup_recruitment_deadline")
    private String studygroupRecruitmentDeadline;
    @Column(name = "article_question_category")
    private Integer articleQuestionCategory;
    @Column(name = "user_code")
    private Integer userCode;
    @Column(name = "studygroup_id")
    private Integer studygroupId;
    @Column(name = "studygroup_current_member_count")
    private Integer studygroupCurrentMemberCount;
    @Column(name = "studygroup_pending_member_count")
    private Integer studygroupPendingMemberCount;
    @Column(name = "article_delete_status")
    private Integer articleDeleteStatus;
}
