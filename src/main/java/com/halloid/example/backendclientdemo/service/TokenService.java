package com.halloid.example.backendclientdemo.service;

import com.halloid.sdk.HalloIDJavaSDK;
import com.halloid.sdk.model.AuthenticationResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class TokenService {

    private final HalloIDJavaSDK halloIDJavaSDK;

    public TokenService(@Value("${halloId.client.id}") String clientID,
                        @Value("${halloId.client.privateKey}") String privateKey,
                        @Value("${halloId.publicKey}") String halloIdPublicKey) {
        this.halloIDJavaSDK = new HalloIDJavaSDK(clientID, privateKey, halloIdPublicKey);
    }

    public String generateToken(){
        return halloIDJavaSDK.generateServiceToken();
    }

    public AuthenticationResponse validateToken(String token) {
        return this.halloIDJavaSDK.validateJWT(token);
    }
}
