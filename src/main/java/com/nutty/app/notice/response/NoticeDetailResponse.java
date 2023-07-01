package com.nutty.app.notice.response;

import com.nutty.app.comment.domain.Comment;
import com.nutty.app.comment.response.CommentsResponse;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Getter
public class NoticeDetailResponse {
    private Long noticeId;
    private String category;
    private String createDate;
    private String description;
    private String title;
    private String writer;
    private List<CommentsResponse> commentList;

    public NoticeDetailResponse(Long noticeId, String category, String createDate, String description, String title, String writer) {
        this.noticeId = noticeId;
        this.category = category;
        this.createDate = createDate;
        this.description = description;
        this.title = title;
        this.writer = writer;
    }

    public void initComments(List<Comment> comments) {
        List<CommentsResponse> collect = comments.stream().map(CommentsResponse::new).collect(Collectors.toList());
        this.commentList = collect;
    }
}
