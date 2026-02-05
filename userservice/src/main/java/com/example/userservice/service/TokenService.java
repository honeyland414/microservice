package com.example.userservice.service;

import com.example.userservice.pojo.JwtToken;
import com.example.userservice.repository.TokenRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TokenService {
    private final TokenRepository tokenRepository;

    public TokenService(TokenRepository tokenRepository) {
        this.tokenRepository = tokenRepository;
    }

    public void createToken(String username, String token) {
        JwtToken jwtToken = new JwtToken();
        jwtToken.setUsername(username);
        jwtToken.setToken(token);
        tokenRepository.save(jwtToken);
    }

    public Optional<JwtToken> getByUsername(String username) {
        return tokenRepository.findByUsername(username);
    }
}
