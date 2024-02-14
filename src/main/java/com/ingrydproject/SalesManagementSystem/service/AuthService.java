package com.ingrydproject.SalesManagementSystem.service;


import com.ingrydproject.SalesManagementSystem.dto.ReqRes;
import com.ingrydproject.SalesManagementSystem.model.User;
import com.ingrydproject.SalesManagementSystem.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class AuthService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private JWTUtils jwtUtils;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private AuthenticationManager authenticationManager;
    public ReqRes signup(ReqRes registrationRequest){
        ReqRes response = new ReqRes();
        try {
            User user = new User();
            user.setEmail(registrationRequest.getEmail());
            user.setPassword(passwordEncoder.encode(registrationRequest.getPassword()));
            user.setRole(registrationRequest.getRole());
            User userResult= userRepository.save(user);
            if (userResult != null && userResult.getId() > 0)  {
                response.setUser(userResult);
                response.setMessage("User Saved Successfully");
                response.setStatusCode(200);
            }
        }catch (Exception e){
            response.setStatusCode(500);
            response.setError(e.getMessage());
        }
        return response;
    }
    public  ReqRes signin(ReqRes singinRequest){
        ReqRes response1 = new ReqRes();
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(singinRequest.getEmail(),singinRequest.getPassword()));
            var user = userRepository.findByEmail(singinRequest.getEmail()).orElseThrow();
            System.out.println("User is: "+ user);
            var jwt = jwtUtils.generateToken(user);
            var refreshToken = jwtUtils.generateToken(new HashMap<>(),user);
            response1.setStatusCode(200);
            response1.setToken(jwt);
            response1.setRefreshToken(refreshToken);
            response1.setExpirationTime("24Hrs");
            response1.setMessage("Signed in successfully");
        }catch (Exception e){
            response1.setStatusCode(500);
            response1.setError(e.getMessage());
        }
        return  response1;
    }
    public ReqRes refreshToken(ReqRes refreshTokenRequest){
        ReqRes response = new ReqRes();
        String ourEmail = jwtUtils.extractUsername(refreshTokenRequest.getToken());
        User users = userRepository.findByEmail(ourEmail).orElseThrow();
        if (jwtUtils.isTokenValid(refreshTokenRequest.getToken(),users)){
            var jwt = jwtUtils.generateToken(users);
            response.setStatusCode(200);
            response.setToken(jwt);
            response.setRefreshToken(refreshTokenRequest.getToken());
            response.setExpirationTime("24Hrs");
            response.setMessage("Successfully refreshed");
        }
        response.setStatusCode(500);
        return response;
    }
}
