package com.nutty.app.comment.service;

import com.nutty.app.comment.domain.Comment;
import com.nutty.app.comment.repository.CommentRepository;
import com.nutty.app.comment.request.CreateCommentRequest;
import com.nutty.app.login.domain.User;
import com.nutty.app.notice.domain.Notice;
import com.nutty.app.notice.repository.NoticeRepository;
import com.nutty.app.notice.repository.NoticeSimpleRepository;
import com.nutty.app.notice.response.NoticeDetailResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CommentService {

    private final CommentRepository commentRepository;
    private final NoticeSimpleRepository noticeRepository;

    @Transactional
    public void createComment(CreateCommentRequest request, User account) {
        Notice notice = noticeRepository.findById(request.getNoticeId()).orElse(null);
        Comment comment = Comment.toEntity(request.getComment(), account,notice);
        commentRepository.createComment(comment);
    }
}
