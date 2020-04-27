package com.dushi.LoginServer.controller;

import com.dushi.LoginServer.dto.LoginRequest;
import com.dushi.LoginServer.dto.RegisterRequest;
import com.dushi.LoginServer.service.AuthService;
import com.dushi.LoginServer.service.AuthenticationResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")

public class BasicAuthController {

    @Autowired
    private AuthService authService;

    @Autowired
    private UserDetailsService userDetailsService;

    @RequestMapping(value = "/signup",method = RequestMethod.POST)
    public ResponseEntity signup(@RequestBody RegisterRequest registerRequest){
        System.out.println("registerRequest");
        authService.signup(registerRequest);
        System.out.println(registerRequest);
        return new ResponseEntity(HttpStatus.OK);
    }

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public AuthenticationResponse signin(@RequestBody LoginRequest loginRequest){
        System.out.println("login path");
        return authService.signin(loginRequest);

    }





}
