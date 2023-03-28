package ru.uxair.authorization.service;

import lombok.NonNull;
import ru.uxair.authorization.entity.JwtAuthentication;
import ru.uxair.authorization.entity.JwtRequest;
import ru.uxair.authorization.entity.JwtResponse;

import javax.security.auth.message.AuthException;

public interface AuthService {
    public JwtResponse username(@NonNull JwtRequest authRequest) throws AuthException;

    public JwtResponse getAccessToken(@NonNull String refreshToken) throws AuthException;

    public JwtResponse refresh(@NonNull String refreshToken) throws AuthException;

    public JwtAuthentication getAuthInfo();
}
