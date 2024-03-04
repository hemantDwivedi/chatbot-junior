package com.devexmaven.chatbotserver.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;

public class ChatDTO {

    @JsonProperty("ChatId")
    private Integer chatId;
    @JsonProperty("Query")
    private String query;
    @JsonProperty("Answer")
    private String answer;

    public ChatDTO() {
    }

    public ChatDTO(Integer chatId, String query, String answer) {
        this.chatId = chatId;
        this.query = query;
        this.answer = answer;
    }

    public Integer getChatId() {
        return chatId;
    }

    public void setChatId(Integer chatId) {
        this.chatId = chatId;
    }

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
}
