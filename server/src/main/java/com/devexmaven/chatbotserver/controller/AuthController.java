package com.devexmaven.chatbotserver.controller;

import com.devexmaven.chatbotserver.dto.request.UserRequest;
import com.devexmaven.chatbotserver.dto.response.UserResponse;
import com.devexmaven.chatbotserver.service.IAuthService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    private final IAuthService authService;

    public AuthController(IAuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/sign-in")
    public ResponseEntity<UserResponse> signInUser(@RequestBody UserRequest userRequest){
        return new ResponseEntity<>(authService.createUser(userRequest), HttpStatus.CREATED);
    }
}
