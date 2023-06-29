package com.nutty.app.login.request;

import lombok.Getter;

import javax.validation.constraints.NotBlank;

@Getter
public class DuplicateRequest {
    @NotBlank(message = "userName은 필수 입력 값입니다.")
    private String userName;
}
