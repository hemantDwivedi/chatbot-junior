package com.devexmaven.chatbotserver.dto.response;

import com.devexmaven.chatbotserver.model.ChatHistory;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
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
}
