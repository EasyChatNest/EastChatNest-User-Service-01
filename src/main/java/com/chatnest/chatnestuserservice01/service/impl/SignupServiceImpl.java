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

import java.util.concurrent.TimeUnit;

@Service
@RequiredArgsConstructor
public class SignupServiceImpl implements SignupService {

    private final UserMapper userMapper;
    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    private final SendVerifyCodeService sendVerifyCodeService;

    private final RedisUtil redisUtil;

    @Override
    public ApiResponse<SignupResponse> register(SignupRequest signupRequest) {
        checkIfRegistered(userMapper, signupRequest);

        String code = sendVerifyCodeService.generateCode();
        sendVerifyCodeService.sendCode(signupRequest.getEmail(), code);
        redisUtil.set("verify:email:" + signupRequest.getEmail(), code, 1, TimeUnit.HOURS);

        storeUserInfo(signupRequest);

        String token = "fakeToken"; // 未来可替换为 JWT 工具类生成
        SignupResponse response = buildSignupResponse(signupRequest, token);
        return ApiResponse.success(response);

    }

    private SignupResponse buildSignupResponse(SignupRequest signupRequest, String token) {
        SignupResponse response = new SignupResponse();
        response.setUsername(signupRequest.getUsername());
        response.setEmail(signupRequest.getEmail());
        response.setToken(token);
        return response;
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

    private void checkIfRegistered(UserMapper userMapper,SignupRequest signupRequest){
        if (userMapper.selectByEmail(signupRequest.getEmail()) != null){
            throw new RuntimeException("The user has been registered before");
        }
    }
}
