package com.chatnest.chatnestuserservice01.dto.Response;

import lombok.Data;

@Data
public class SignupResponse {
    private Long userId;
    private String username;
    private String nickname;
    private String email;
    private String token;
    private String message; // e.g., "Signup successful"
    private int code; // e.g., 200

}
