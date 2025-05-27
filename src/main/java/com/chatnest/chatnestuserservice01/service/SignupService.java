package com.chatnest.chatnestuserservice01.service;

import com.chatnest.chatnestuserservice01.dto.Request.SignupRequest;
import com.chatnest.chatnestuserservice01.dto.Response.SignupResponse;

public interface SignupService {

     SignupResponse register(SignupRequest signupRequest);

}
