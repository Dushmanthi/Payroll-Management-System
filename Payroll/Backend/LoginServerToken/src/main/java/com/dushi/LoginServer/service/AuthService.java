package com.dushi.LoginServer.service;

import com.dushi.LoginServer.dto.LoginRequest;
import com.dushi.LoginServer.dto.RegisterRequest;

public interface AuthService {
    public void signup(RegisterRequest registerRequest);
    public String signin(LoginRequest loginRequest);
}
