package com.ingrydproject.SalesManagementSystem.controller;

import com.ingrydproject.SalesManagementSystem.dto.ReqRes;
import com.ingrydproject.SalesManagementSystem.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    private AuthService authService;
    @PostMapping("/signup")
    public ResponseEntity<ReqRes> signUp(@RequestBody ReqRes signupRequest){
        return  ResponseEntity.ok(authService.signup(signupRequest));
    }
    @PostMapping("/signin")
    public ResponseEntity<ReqRes> signIn(@RequestBody ReqRes signinRequest){
        return  ResponseEntity.ok(authService.signin(signinRequest));
    }
    @PostMapping("/refreshToken")
    public ResponseEntity<ReqRes> refreshTokenRequest(@RequestBody ReqRes refreshTokenRequest){
        return  ResponseEntity.ok(authService.refreshToken(refreshTokenRequest));
    }
}
