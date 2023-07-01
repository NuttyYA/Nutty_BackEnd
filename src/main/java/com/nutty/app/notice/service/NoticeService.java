package com.nutty.app.notice.service;

import com.nutty.app.comment.domain.Comment;
import com.nutty.app.comment.repository.CommentRepository;
import com.nutty.app.comment.response.CommentsResponse;
import com.nutty.app.login.domain.User;
import com.nutty.app.notice.domain.Notice;
import com.nutty.app.notice.repository.NoticeRepository;
import com.nutty.app.notice.request.CreateNoticeRequest;
import com.nutty.app.notice.response.NoticeDetailResponse;
import com.nutty.app.notice.response.NoticeMainPageResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class NoticeService {

    private final NoticeRepository noticeRepository;
    private final CommentRepository commentRepository;
    public List<NoticeMainPageResponse> getMainPage() {
        List<Notice> noticeList = noticeRepository.findMainList();
        List<NoticeMainPageResponse> collect = noticeList.stream()
                .map(NoticeMainPageResponse::new).collect(Collectors.toList());
        return collect;
    }

    @Transactional
    public void createNotice(CreateNoticeRequest request, User account) {
        Notice notice = Notice.toEntity(request,account);
        noticeRepository.insertNotice(notice);
    }

    public NoticeDetailResponse getNoticeDetail(Long noticeId) {
        NoticeDetailResponse noticeDetail = noticeRepository.findNoticeDetail(noticeId);
        List<Comment> comments = commentRepository.selectCommentList(noticeId);
        noticeDetail.initComments(comments);
        return noticeDetail;
    }
}
