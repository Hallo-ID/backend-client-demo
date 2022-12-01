package com.halloid.example.backendclientdemo.controller;

import com.halloid.example.backendclientdemo.service.TokenService;
import com.halloid.sdk.model.AuthenticationResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("auth/token")
@CrossOrigin(origins = "http://localhost:3001")
public class AuthenticationController {

    @Autowired
    private TokenService tokenService;

    @GetMapping
    public ResponseEntity<TokenWrapper> generateToken(){
        String token = tokenService.generateToken();
        return ResponseEntity.ok(new TokenWrapper(token));
    }

    @GetMapping("{token}/verify")
    public ResponseEntity<AuthenticationResponse> verifyToken(@PathVariable String token) {
        AuthenticationResponse authPayload = tokenService.validateToken(token);
        return ResponseEntity.ok(authPayload);
    }

    private class TokenWrapper {
        private String token;
        public TokenWrapper(String token) {
            this.token = token;
        }

        public String getToken() {
            return token;
        }

        public void setToken(String token) {
            this.token = token;
        }
    }

}
