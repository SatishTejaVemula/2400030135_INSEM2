package com.example.auth_contract.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.auth_contract.dto.SigninRequest;
import com.example.auth_contract.dto.SigninResponse;
import com.example.auth_contract.service.AuthService;

@RestController
@RequestMapping("/ms1")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/signin")
    public ResponseEntity<SigninResponse> signin(
            @RequestBody SigninRequest request) {

        String token = authService.signin(
                request.getUsername(),
                request.getPassword()
        );

        return ResponseEntity.ok(new SigninResponse(token));
    }
}