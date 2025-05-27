package com.chatnest.chatnestuserservice01.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
import java.time.LocalDateTime;

@Data
public class User {
    private Long id;
    private String username;
    private String email;
    private String phone;
    private String password;
    private String nickname;
    private String gender;
    private String region;

}
