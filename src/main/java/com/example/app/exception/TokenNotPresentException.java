package com.example.app.exception;

public class TokenNotPresentException extends RuntimeException {
    public TokenNotPresentException(String message) {
        super(message);
    }
}
