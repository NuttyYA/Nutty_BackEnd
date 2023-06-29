package com.nutty.app.notice.controller;

import com.nutty.app.login.jwt.UserDetailsImpl;
import com.nutty.app.notice.request.CreateNoticeRequest;
import com.nutty.app.notice.response.NoticeMainPageResponse;
import com.nutty.app.notice.service.NoticeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class NoticeController {

    private final NoticeService noticeService;

    @Operation(summary = "메인페이지 게시글 조회 API", description = "메인페이지 게시글 조회 API", tags = { "NoticeController" })
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "OK")
    })
    @GetMapping ("/v1/api/notice/main")
    public List<NoticeMainPageResponse> mainPage(){
        return noticeService.getMainPage();
    }


    @Operation(summary = "게시글 작성 API", description = "게시글 작성 API", tags = { "NoticeController" })
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "OK")
    })
    @PostMapping ("/v1/api/notice")
    public String createNotice(@Valid @RequestBody CreateNoticeRequest request, @AuthenticationPrincipal UserDetailsImpl userDetails){
        noticeService.createNotice(request, userDetails.getAccount());
        return "게시글 작성 완료";
    }
}
