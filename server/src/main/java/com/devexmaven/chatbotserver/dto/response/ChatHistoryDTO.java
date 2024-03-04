package com.devexmaven.chatbotserver.dto.response;

import com.devexmaven.chatbotserver.model.Chat;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class ChatHistoryDTO {
    @JsonProperty("ChatHistoryId")
    private Integer chatHistoryId;

    @JsonProperty("Chats")
    private List<Chat> chats;

    public ChatHistoryDTO() {
    }

    public ChatHistoryDTO(Integer chatHistoryId, List<Chat> chats) {
        this.chatHistoryId = chatHistoryId;
        this.chats = chats;
    }

    public Integer getChatHistoryId() {
        return chatHistoryId;
    }

    public void setChatHistoryId(Integer chatHistoryId) {
        this.chatHistoryId = chatHistoryId;
    }

    public List<Chat> getChats() {
        return chats;
    }

    public void setChats(List<Chat> chats) {
        this.chats = chats;
    }
}
