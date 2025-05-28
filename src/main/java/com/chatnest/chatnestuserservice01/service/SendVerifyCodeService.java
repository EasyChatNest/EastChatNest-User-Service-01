package com.chatnest.chatnestuserservice01.service;

public interface SendVerifyCodeService {

    void sendCode(String email);
    boolean verifyCode(String email, String inputCode);
    String generateCode();


}
