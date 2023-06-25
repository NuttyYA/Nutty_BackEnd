package com.nutty.app.login.response;

import com.nutty.app.login.jwt.UserDetailsImpl;
import lombok.Getter;

@Getter
public class UserInfoResponse {
    private String email;
    private String mbti;
    private String userName;

    public static UserInfoResponse getInfo(UserDetailsImpl userDetails) {
        UserInfoResponse response = new UserInfoResponse();
        response.userName = userDetails.getAccount().getUserName();
        response.mbti = userDetails.getAccount().getMbti();
        response.userName = userDetails.getAccount().getEmail();
        return response;
    }
}
