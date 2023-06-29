package com.nutty.app.notice.request;

import lombok.Getter;

@Getter
public class CreateNoticeRequest {
    private String category;
    private String title;
    private String description;
    private String createDate;
}
