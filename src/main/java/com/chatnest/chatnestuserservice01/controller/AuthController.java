package com.chatnest.chatnestuserservice01.controller;

import com.chatnest.chatnestuserservice01.common.response.ApiResponse;
import com.chatnest.chatnestuserservice01.dto.Request.SignupRequest;
import com.chatnest.chatnestuserservice01.dto.Response.SignupResponse;
import com.chatnest.chatnestuserservice01.service.SignupService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final SignupService signupService;

    /**
     * 用户注册接口
     * @param signupRequest 用户注册请求体
     * @return 包含注册信息和 Token 的响应
     */
    @PostMapping("/signup")
    public ApiResponse<SignupResponse> signup(@RequestBody SignupRequest signupRequest) {
        System.out.println(">>> Controller triggered!");
        return signupService.register(signupRequest);
    }

    @GetMapping("/ping")
    public String ping() {
        return "pong";
    }

}
