package com.chatnest.chatnestuserservice01.service;

import com.chatnest.chatnestuserservice01.common.response.ApiResponse;
import com.chatnest.chatnestuserservice01.dto.Response.SigninResponse;

public interface LoginService {

    public ApiResponse<SigninResponse> Login(SigninResponse loginRequest);
}
