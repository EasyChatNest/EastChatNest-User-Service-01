package com.chatnest.chatnestuserservice01.dto.Request;

import lombok.Data;

@Data
public class SignupRequest {
    private String username;
    private String email;
    private String phone;
    private String password;
    private String nickname;
    private String gender;
    private String region;
}
