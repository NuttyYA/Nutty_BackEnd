package com.nutty.app.login.request;


import com.nutty.app.login.domain.User;
import lombok.Getter;

import javax.validation.constraints.NotBlank;


@Getter
public class SignUpRequest {
    @NotBlank(message = "mbti는 필수 입력 값입니다.")
    private String mbti;
    @NotBlank(message = "email은 필수 입력 값입니다.")
    private String email;
    @NotBlank(message = "필명은 필수 입력 값입니다.")
    private String userName;
    @NotBlank(message = "비밀번호는 필수 입력 값입니다.")
    private String password;

    public User toEntity() {
        User user = new User();
        user.initData(this);
        return user;
    }

    public void initPassword(String encode) {
        this.password = encode;
    }
}
