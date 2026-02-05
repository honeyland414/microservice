package com.example.userservice.pojo;

import lombok.Data;

@Data
public class LoginRequest {
    private String username;
    private String password;
}
