package com.nutty.app.notice.repository;

import com.nutty.app.notice.domain.Notice;
import com.nutty.app.notice.response.NoticeDetailResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class NoticeRepository {
    private final EntityManager em;

    public List<Notice> findMainList() {
        return em.createQuery("select n from Notice n")
                .getResultList();
    }

    public void insertNotice(Notice notice) {
        em.persist(notice);
    }

    public NoticeDetailResponse findNoticeDetail(Long noticeId) {
        return em.createQuery("select new com.nutty.app.notice.response.NoticeDetailResponse(" +
                "n.id, n.category, n.createDate, n.description, n.title, u.userName)" +
                " from Notice n" +
                " join n.user u" +
                " where n.id = :noticeId", NoticeDetailResponse.class)
                .setParameter("noticeId", noticeId)
                .getSingleResult();
    }
}
