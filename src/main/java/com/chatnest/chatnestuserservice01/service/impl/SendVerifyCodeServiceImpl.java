package com.chatnest.chatnestuserservice01.service.impl;

import com.chatnest.chatnestuserservice01.service.SendVerifyCodeService;
import org.springframework.stereotype.Service;
import java.util.Random;

@Service
public class SendVerifyCodeServiceImpl implements SendVerifyCodeService {
    @Override
    public void sendCode(String email) {
        System.out.println("Code has been sent");

    }
    @Override
    public boolean verifyCode(String email, String inputCode) {
        return false;
    }

    @Override
    public String generateCode() {
        return String.format("%06d", new Random().nextInt(999999));
    }

}
