package com.learnon.controller;

import com.learnon.model.dto.AuthRequest;
import com.learnon.model.dto.AuthResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody AuthRequest req) {
        // Stubbed: validate and issue token
        AuthResponse resp = new AuthResponse();
        resp.setToken("stubbed-jwt-token");
        resp.setExpiresIn(3600);
        return ResponseEntity.ok(resp);
    }
}
