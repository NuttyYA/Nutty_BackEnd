package com.nutty.app.login.domain;

import com.nutty.app.login.request.SignUpRequest;
import lombok.Getter;

import javax.persistence.*;

@Entity
@Getter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;

    private String email;
    private String password;
    private String mbti;
    private String userName;

    public void initData(SignUpRequest signUpRequest) {
        this.email = signUpRequest.getEmail();
        this.password = signUpRequest.getPassword();
        this.mbti = signUpRequest.getMbti();
        this.userName = signUpRequest.getUserName();
    }
}
