package com.dushi.LoginServer.service;

import com.dushi.LoginServer.dto.LoginRequest;
import com.dushi.LoginServer.dto.RegisterRequest;
import com.dushi.LoginServer.model.User;
import com.dushi.LoginServer.repository.UserRepository;
import com.dushi.LoginServer.security.JwtProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtProvider jwtProvider;

    @Override
    public void signup(RegisterRequest registerRequest) {
        User user = new User();
        user.setUserName(registerRequest.getUsername());
        user.setPassword(encodePassword(registerRequest.getPassword()));
        System.out.println(registerRequest.getUsername());
        System.out.println(registerRequest.getPassword());
        userRepository.save(user);
    }

    @Override
    public String signin(LoginRequest loginRequest) {
        Authentication authenticate = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                loginRequest.getUsername(), loginRequest.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authenticate);
        return jwtProvider.generateToken(authenticate);
    }

    private String encodePassword(String password) {
        System.out.println(passwordEncoder.encode(password));
        return passwordEncoder.encode(password);
    }
}
