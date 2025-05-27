package com.chatnest.chatnestuserservice01.service;

import com.chatnest.chatnestuserservice01.common.response.ApiResponse;
import com.chatnest.chatnestuserservice01.dto.Request.SignupRequest;
import com.chatnest.chatnestuserservice01.dto.Response.SignupResponse;

public interface SignupService {

     ApiResponse<SignupResponse> register(SignupRequest signupRequest);

}
