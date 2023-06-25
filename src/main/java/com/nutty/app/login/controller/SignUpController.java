package com.nutty.app.login.controller;

import com.nutty.app.login.domain.User;
import com.nutty.app.login.request.SignUpRequest;
import com.nutty.app.login.service.SignUpService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequiredArgsConstructor
public class SignUpController {

    private final SignUpService signUpService;
    private final PasswordEncoder passwordEncoder;

    @Operation(summary = "회원가입 API", description = "회원가입 API", tags = { "SignUpController" })
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "OK")
    })
    @PostMapping("/v1/api/signup")
    public String signup(@Valid @RequestBody SignUpRequest request){
        String encode = passwordEncoder.encode(request.getPassword());
        request.initPassword(encode);
        signUpService.signUp(request);
        return "회원가입 완료";
    }

    @Operation(summary = "회원가입 목록 API", description = "회원가입 확인 전용 API", tags = { "SignUpController" })
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "OK")
    })
    @GetMapping("/v1/api/signup/check")
    public List<User> signupCheck(){
        return signUpService.getUserList();
    }

}
