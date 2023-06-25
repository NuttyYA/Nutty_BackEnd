package com.nutty.app.login.controller;

import com.nutty.app.config.JwtUtil;
import com.nutty.app.login.domain.RefreshToken;
import com.nutty.app.login.dto.TokenDto;
import com.nutty.app.login.jwt.UserDetailsImpl;
import com.nutty.app.login.repository.RefreshTokenRepository;
import com.nutty.app.login.request.LoginRequest;
import com.nutty.app.login.response.UserInfoResponse;
import com.nutty.app.login.service.LoginService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class LoginController {
    private final JwtUtil jwtUtil;
    private final PasswordEncoder passwordEncoder;
    private final LoginService loginService;
    private final RefreshTokenRepository refreshTokenRepository;


    @Operation(summary = "로그인 API", description = "로그인 API", tags = { "LoginController" })
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "OK")
    })
    @PostMapping("/v1/api/login")
    public TokenDto login(@RequestBody LoginRequest loginRequest){
        // 아이디 정보로 Token생성
        TokenDto tokenDto = jwtUtil.createAllToken(loginRequest.getEmail());

        // Refresh토큰 있는지 확인
        Optional<RefreshToken> refreshToken = refreshTokenRepository.findByAccountEmail(loginRequest.getEmail());

        // 있다면 새토큰 발급후 업데이트
        // 없다면 새로 만들고 디비 저장
        if(refreshToken.isPresent()) {
            refreshTokenRepository.save(refreshToken.get().updateToken(tokenDto.getRefreshToken()));
        }else {
            RefreshToken newToken = new RefreshToken(tokenDto.getRefreshToken(), loginRequest.getEmail());
            refreshTokenRepository.save(newToken);
        }

        return tokenDto;
    }

    @Operation(summary = "회원정보 조회 API", description = "회원정보 조회 API", tags = { "LoginController" })
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "OK")
    })
    @GetMapping("/v1/api/info")
    public UserInfoResponse userInfo(@AuthenticationPrincipal UserDetailsImpl userDetails){
        return UserInfoResponse.getInfo(userDetails);
    }
}
