package com.nutty.app.login.domain;

import com.nutty.app.login.request.SignUpRequest;
import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;
    private String password;
    private String mbti;

    public void initData(SignUpRequest signUpRequest) {
        this.email = signUpRequest.getEmail();
        this.password = signUpRequest.getPassword();
        this.mbti = signUpRequest.getMbti();
    }
}
