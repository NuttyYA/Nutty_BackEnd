package com.nutty.app.login.repository;

import com.nutty.app.login.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SignUpRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
}
