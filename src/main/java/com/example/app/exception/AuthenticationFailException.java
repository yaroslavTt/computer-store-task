package com.example.app.exception;

public class AuthenticationFailException extends RuntimeException {
    public AuthenticationFailException(String message) {
        super(message);
    }
}
