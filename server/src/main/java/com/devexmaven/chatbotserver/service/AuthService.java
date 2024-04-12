package com.devexmaven.chatbotserver.service;

import com.devexmaven.chatbotserver.dto.request.UserRequest;
import com.devexmaven.chatbotserver.dto.response.UserResponse;
import com.devexmaven.chatbotserver.model.User;
import com.devexmaven.chatbotserver.repository.UserRepository;
import com.devexmaven.chatbotserver.utils.MapperHelper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
@AllArgsConstructor
public class AuthService implements IAuthService{
    private UserRepository userRepository;
    private MapperHelper mapper;

    @Override
    public UserResponse createUser(UserRequest userRequest) {
        User user = mapper.userRequestToUser(userRequest);
        User savedUser = userRepository.save(user);
        return mapper.userToUserResponse(savedUser);
    }

    @Override
    public UserResponse updateUser(UserRequest userRequest) {
        User user = userRepository.findByEmail(userRequest.getEmail());
        User updatedUser = mapper.updateEntity(user, userRequest);
        User savedUser = userRepository.save(updatedUser);
        return mapper.userToUserResponse(savedUser);
    }

    @Override
    public List<UserResponse> getAllUsers() {
        return Collections.emptyList();
    }
}
