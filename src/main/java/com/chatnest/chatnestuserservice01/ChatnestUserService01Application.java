package com.chatnest.chatnestuserservice01;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
//@ComponentScan(basePackages = "com.chatnest.chatnestuserservice01")
public class ChatnestUserService01Application {

    public static void main(String[] args) {
        SpringApplication.run(ChatnestUserService01Application.class, args);
    }

    @RestController
    @RequestMapping("/test")
    static class DebugController {
        @GetMapping("/ping")
        public String ping() {
            return "pong from test";
        }
    }
}
