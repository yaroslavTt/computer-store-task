package com.example.app.exception;

public class UserAlreadyPresentException extends RuntimeException {
    public UserAlreadyPresentException(String message) {
        super(message);
    }
}
