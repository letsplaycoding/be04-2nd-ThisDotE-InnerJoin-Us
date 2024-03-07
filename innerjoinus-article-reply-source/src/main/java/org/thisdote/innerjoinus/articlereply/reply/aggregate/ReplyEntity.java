package org.thisdote.innerjoinus.articlereply.reply.aggregate;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Table(name = "reply")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class ReplyEntity {
    @Id
    @Column(name = "reply_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer replyId;

    @Column(name = "reply_report_status")
    private Integer replyReportStatus;

    @Column(name = "reply_content")
    private String replyContent;

    @Column(name = "reply_create_date")
    private Date replyCreatedDate;

    @Column(name = "reply_last_update_date")
    private Date replyLastUpdateDate;

    @Column(name = "reply_like_count")
    private Integer replyLikeCount;

    @Column(name = "user_code")
    private Integer userCode;

    @Column(name = "artcle_id")
    private Integer articleId;

    @Column(name = "reply_delete_status")
    private Integer replyDeleteStatus;
}
