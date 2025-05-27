package com.chatnest.chatnestuserservice01.service.impl;

import com.chatnest.chatnestuserservice01.dto.Request.SignupRequest;
import com.chatnest.chatnestuserservice01.dto.Response.SignupResponse;
import com.chatnest.chatnestuserservice01.service.SignupService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SignupServiceImpl implements SignupService {

    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();






    @Override
    public SignupResponse register(SignupRequest signupRequest) {

        return null;
    }
}
