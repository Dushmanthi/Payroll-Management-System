package com.dushi.LoginServer.service;

import com.dushi.LoginServer.dto.LoginRequest;
import com.dushi.LoginServer.dto.RegisterRequest;

public interface AuthService {
     void signup(RegisterRequest registerRequest);
     AuthenticationResponse signin(LoginRequest loginRequest);
}
