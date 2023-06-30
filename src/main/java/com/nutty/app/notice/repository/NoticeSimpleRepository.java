package com.nutty.app.notice.repository;

import com.nutty.app.notice.domain.Notice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NoticeSimpleRepository extends JpaRepository<Notice, Long> {
}
