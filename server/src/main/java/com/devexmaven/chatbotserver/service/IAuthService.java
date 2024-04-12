package com.devexmaven.chatbotserver.service;

import com.devexmaven.chatbotserver.dto.request.UserRequest;
import com.devexmaven.chatbotserver.dto.response.UserResponse;

import java.util.List;

public interface IAuthService {
    UserResponse createUser(UserRequest user);
    UserResponse updateUser(UserRequest userRequest);
    List<UserResponse> getAllUsers();
}
