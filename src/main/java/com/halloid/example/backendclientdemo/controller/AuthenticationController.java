package com.halloid.example.backendclientdemo.controller;

import com.halloid.example.backendclientdemo.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("auth/token")
public class AuthenticationController {

    @Autowired
    private TokenService tokenService;

    @GetMapping
    public ResponseEntity<String> generateToken(){
        String token = tokenService.generateToken();
        return ResponseEntity.ok(token);
    }

    @GetMapping("{token}/verify")
    public ResponseEntity<Boolean> verifyToken(@PathVariable String token) {
        Boolean isValidToken = tokenService.validateToken(token).getTokenVerified();
        return ResponseEntity.ok(isValidToken);
    }

}
