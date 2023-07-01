package com.nutty.app.comment.response;

import com.nutty.app.comment.domain.Comment;
import lombok.Getter;

import java.util.List;

@Getter
public class CommentsResponse {
    private String writer;
    private String comment;
    private String createDate;

    public CommentsResponse(Comment comment) {
        this.writer = comment.getUser().getUserName();
        this.comment = comment.getComment();
        this.createDate = comment.getCreateDate();
    }
}
