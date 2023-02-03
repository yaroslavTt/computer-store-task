package com.example.app.service;

import com.example.app.model.user.AuthenticationToken;
import com.example.app.model.user.User;
import com.example.app.repository.TokenRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
    private final TokenRepository tokenRepository;

    public void saveConfirmationToken(AuthenticationToken authenticationToken){
        tokenRepository.save(authenticationToken);
    }

    public AuthenticationToken getToken(User user){
        return tokenRepository.findByUser(user);
    }
}
