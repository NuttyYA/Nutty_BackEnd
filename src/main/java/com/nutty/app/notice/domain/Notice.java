package com.nutty.app.notice.domain;

import com.nutty.app.login.domain.User;
import com.nutty.app.notice.request.CreateNoticeRequest;
import lombok.Getter;

import javax.persistence.*;

@Entity
@Getter
public class Notice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String createDate;
    private String title;
    private String description;
    private String category;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    public static Notice toEntity(CreateNoticeRequest request, User account) {
        Notice notice = new Notice();
        notice.initData(request,account);
        return notice;
    }

    private void initData(CreateNoticeRequest request, User account) {
        this.createDate = request.getCreateDate();
        this.title = request.getTitle();
        this.description = request.getDescription();
        this.category = request.getCategory();
        this.user = account;
    }
}
