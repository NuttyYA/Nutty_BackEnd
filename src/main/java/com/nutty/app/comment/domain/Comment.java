package com.nutty.app.comment.domain;

import com.nutty.app.comment.request.CreateCommentRequest;
import com.nutty.app.login.domain.User;
import com.nutty.app.notice.domain.Notice;
import lombok.Getter;

import javax.persistence.*;

@Entity
@Getter
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "comment_id")
    private Long id;

    private String comment;
    private String createDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "notice_id")
    private Notice notice;

    public static Comment toEntity(CreateCommentRequest comment, User account, Notice notice) {
        Comment response = new Comment();
        response.initData(comment.getComment(),comment.getCreateDate(), account,notice);
        return response;
    }

    private void initData(String comment,String createDate, User account, Notice notice) {
        this.comment = comment;
        this.createDate = createDate;
        this.user = account;
        this.notice = notice;
    }
}
