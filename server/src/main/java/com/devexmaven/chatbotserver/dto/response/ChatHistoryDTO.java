package com.devexmaven.chatbotserver.dto.response;

import com.devexmaven.chatbotserver.model.Chat;
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
public class ChatHistoryDTO {
    @JsonProperty("ChatHistoryId")
    private Integer chatHistoryId;

    @JsonProperty("Chats")
    private List<Chat> chats;
}
