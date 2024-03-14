package com.devexmaven.chatbotserver.dto.response;

import com.devexmaven.chatbotserver.model.ChatHistory;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class UserResponse {
    @JsonProperty("UserId")
    private Long userId;
    @JsonProperty("FirstName")
    private String firstName;
    @JsonProperty("LastName")
    private String lastName;
    @JsonProperty("Email")
    private String email;
    @JsonProperty("ChatHistory")
    private List<ChatHistory> chatHistories;

    public UserResponse() {
    }

    public UserResponse(Long userId, String firstName, String lastName, String email, List<ChatHistory> chatHistories) {
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.chatHistories = chatHistories;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<ChatHistory> getChatHistories() {
        return chatHistories;
    }

    public void setChatHistories(List<ChatHistory> chatHistories) {
        this.chatHistories = chatHistories;
    }
}
