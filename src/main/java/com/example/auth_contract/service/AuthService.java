package com.example.auth_contract.service;

import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class AuthService {

    public String signin(String username, String password) {

        if ("satish".equals(username)
                && "password123".equals(password)) {

            return UUID.randomUUID().toString();
        }

        throw new ResponseStatusException(
                HttpStatus.UNAUTHORIZED,
                "Invalid username or password"
        );
    }
}