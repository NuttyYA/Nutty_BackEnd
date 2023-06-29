package com.nutty.app.notice.response;

import com.nutty.app.notice.domain.Notice;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class NoticeMainPageResponse {
    private Long noticeId;
    private String title;
    private String description;

    public NoticeMainPageResponse(Notice notice) {
        fromEntity(notice);
    }

    private void fromEntity(Notice notice){
        this.noticeId = notice.getId();
        this.title = notice.getTitle();
        this.description = notice.getDescription();
    }
}