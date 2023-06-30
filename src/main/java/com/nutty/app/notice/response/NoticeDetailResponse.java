package com.nutty.app.notice.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
public class NoticeDetailResponse {
    private Long noticeId;
    private String category;
    private String createDate;
    private String description;
    private String title;
    private String writer;

    public NoticeDetailResponse(Long noticeId, String category, String createDate, String description, String title, String writer) {
        this.noticeId = noticeId;
        this.category = category;
        this.createDate = createDate;
        this.description = description;
        this.title = title;
        this.writer = writer;
    }
}
