package com.devexmaven.chatbotserver.controller;

import com.devexmaven.chatbotserver.dto.request.UserRequest;
import com.devexmaven.chatbotserver.dto.response.UserResponse;
import com.devexmaven.chatbotserver.service.IAuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {
    private IAuthService authService;

    @PostMapping("/signup")
    public ResponseEntity<UserResponse> signUp(@RequestBody UserRequest userRequest){
        return new ResponseEntity<>(authService.createUser(userRequest), HttpStatus.CREATED);
    }
}
