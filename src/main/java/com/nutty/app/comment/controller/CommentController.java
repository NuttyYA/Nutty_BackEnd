package com.nutty.app.comment.controller;

import com.nutty.app.comment.request.CreateCommentRequest;
import com.nutty.app.comment.service.CommentService;
import com.nutty.app.login.jwt.UserDetailsImpl;
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

@RestController
@RequiredArgsConstructor
public class CommentController {

    private final CommentService commentService;

    @Operation(summary = "댓글 작성 API", description = "댓글 작성 API", tags = { "CommentController" })
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "OK")
    })
    @PostMapping("/v1/api/comment")
    public String createComment(@Valid @RequestBody CreateCommentRequest request, @AuthenticationPrincipal UserDetailsImpl userDetails){
        commentService.createComment(request,userDetails.getAccount());
        return "댓글 작성완료";
    }
}
