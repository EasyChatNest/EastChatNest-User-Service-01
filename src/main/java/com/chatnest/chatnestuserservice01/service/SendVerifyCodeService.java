package com.chatnest.chatnestuserservice01.service;

public interface SendVerifyCodeService {
    void sendCode(String email, String code);        // 只发送验证码
    boolean verifyCode(String email, String inputCode);  // 校验验证码
    // 记忆功能交给 redis
    String generateCode();                           // 生成验证码

}
