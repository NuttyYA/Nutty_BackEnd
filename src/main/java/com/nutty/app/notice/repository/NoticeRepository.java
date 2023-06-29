package com.nutty.app.notice.repository;

import com.nutty.app.notice.domain.Notice;
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
}
