package com.dushi.LoginServer.controller;

import com.dushi.LoginServer.dto.LoginRequest;
import com.dushi.LoginServer.dto.RegisterRequest;
import com.dushi.LoginServer.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;

//@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/auth")

public class BasicAuthController {

    @Autowired
    private AuthService authService;

    @Autowired
    private UserDetailsService userDetailsService;

//    @GetMapping(path = "/basicauth")
//    public Authentication basicauth() {
//        return new Authentication("You are authenticated");
//    }

    @RequestMapping(value = "/signup",method = RequestMethod.POST)
    public ResponseEntity signup(@RequestBody RegisterRequest registerRequest){
        System.out.println("registerRequest");
        authService.signup(registerRequest);
        System.out.println(registerRequest);
        return new ResponseEntity(HttpStatus.OK);
    }

    @RequestMapping(value = "/signin",method = RequestMethod.POST)
    public String signin(@RequestBody LoginRequest loginRequest){
        return authService.signin(loginRequest);

    }

}
