package com.nutty.app.login.repository;

import com.nutty.app.login.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SignUpRepository extends JpaRepository<User, Long> {
}
