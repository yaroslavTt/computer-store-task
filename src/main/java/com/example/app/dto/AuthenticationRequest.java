package com.example.app.dto;

import lombok.*;

@Data
public class AuthenticationRequest {
    private String login;
    private String password;
}
