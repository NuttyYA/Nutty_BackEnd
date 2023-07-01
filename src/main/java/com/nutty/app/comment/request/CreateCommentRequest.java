package com.nutty.app.comment.request;

import lombok.Getter;

@Getter
public class CreateCommentRequest {
    private Long noticeId;
    private String comment;
    private String createDate;
}
