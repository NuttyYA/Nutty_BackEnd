package com.nutty.app.login.service;

import com.nutty.app.login.domain.User;
import com.nutty.app.login.repository.SignUpRepository;
import com.nutty.app.login.request.SignUpRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SignUpService {
    private final SignUpRepository signUpRepository;
    @Transactional
    public void signUp(SignUpRequest request) {
        User user = request.toEntity();
        signUpRepository.save(user);
    }

    public List<User> getUserList() {

        return signUpRepository.findAll();
    }
}
