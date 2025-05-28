package com.chatnest.chatnestuserservice01.service.impl;

import com.chatnest.chatnestuserservice01.common.response.ApiResponse;
import com.chatnest.chatnestuserservice01.dto.Request.SignupRequest;
import com.chatnest.chatnestuserservice01.dto.Response.SignupResponse;
import com.chatnest.chatnestuserservice01.entity.User;
import com.chatnest.chatnestuserservice01.mapper.UserMapper;
import com.chatnest.chatnestuserservice01.service.SendVerifyCodeService;
import com.chatnest.chatnestuserservice01.service.SignupService;
import com.chatnest.chatnestuserservice01.utils.RedisUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SignupServiceImpl implements SignupService {

    private final UserMapper userMapper;
    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    private final SendVerifyCodeService sendVerifyCodeService;

    private final RedisUtil redisUtil;

    @Override
    public ApiResponse<SignupResponse> register(SignupRequest signupRequest) {
        // Now assume we only allow register and sign in by Email
        // check if the email or the phone number has been registered before
        checkifRegistered(userMapper,signupRequest);
        // After this line, means it is a new user
        // send Verify Code to the inputted email (use SendVertifyCodeServiceImpl)
        // FeignClient
//        sendVerifyCodeService.sendCode("signupRequest.getEmail()");
        System.out.println("Sending verification code to: " + signupRequest.getEmail());

        sendVerifyCodeService.sendCode(signupRequest.getEmail(),sendVerifyCodeService.generateCode());
        // save the vertify code into redis


        // save the Token in redis
        // use Redis Util


        // save the user's information into MySQL
        storeUserInfo(signupRequest);

        // send back the SignupResponse to the frontend with Token
        // Fill the signup response

        return null;
    }

    private void storeUserInfo(SignupRequest signupRequest){
        User user = new User();
        // input the data
        user.setUsername(signupRequest.getUsername());
        user.setEmail(signupRequest.getEmail());
        user.setPhone(signupRequest.getPhone());
        user.setNickname(signupRequest.getNickname());
        user.setGender(signupRequest.getGender());
        user.setRegion(signupRequest.getRegion());
        // passwordEncoder.encode(signupRequest.getPassword()) 加密
        user.setPassword(passwordEncoder.encode(signupRequest.getPassword()));
        userMapper.insertUser(user);
    }

    private void checkifRegistered(UserMapper userMapper,SignupRequest signupRequest){
        if (userMapper.selectByEmail(signupRequest.getEmail()) != null){
            throw new RuntimeException("The user has been registered before");
        }
    }
}
