package com.chatnest.chatnestuserservice01.service.impl;
import com.chatnest.chatnestuserservice01.service.SendVerifyCodeService;
import com.chatnest.chatnestuserservice01.utils.RedisUtil;
import jakarta.validation.constraints.Min;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;
import java.util.Random;
import java.util.concurrent.TimeUnit;

@Service
@RequiredArgsConstructor
public class SendVerifyCodeServiceImpl implements SendVerifyCodeService {

    private static final long CODE_EXPIRE_MINUTES = 5;
    private final RedisUtil redisUtil;

    @Override
    public void sendCode(String email, String code) {
        // 假设已经集成邮件服务了
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(email);
        message.setSubject("Your Verification Code");
        message.setText("Your verification code is: " + code + "\nIt will expire in 5 minutes.");
        message.setFrom("zidiyaocanada@outlook.comm");
        // save the code into redis
        saveCodeIntoRedis(email,code);
        // End
        System.out.println("Sending code to email: " + email + " code: " + code);
    }

    @Override
    public boolean verifyCode(String email, String inputCode) {
        String key = "verify:code:" + email;
        String realCode = redisUtil.get(key);
        return realCode != null && realCode.equals(inputCode);
    }

    @Override
    public String generateCode() {
        return String.format("%06d", new Random().nextInt(999999));
    }

    /**
     *
     * @param email
     * @param code
     * 用于存临时 Code 在 redis 里
     */
    private void saveCodeIntoRedis(String email, String code) {
        redisUtil.set("verify:code:" + email,code,CODE_EXPIRE_MINUTES, TimeUnit.MINUTES);
        // code 被存入 redis 中, 5 min 后失效
    }
}
