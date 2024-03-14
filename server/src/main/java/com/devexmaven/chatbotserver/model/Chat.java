package com.devexmaven.chatbotserver.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

@Entity
public class Chat {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonProperty("ChatId")
    @Column(name = "chat_id")
    private Integer chatId;
    @JsonProperty("Query")
    @Column(nullable = false)
    private String query;
    @JsonProperty("Answer")
    @Column(nullable = false)
    private String answer;

    public Chat() {
    }

    public Chat(Integer chatId, String query, String answer) {
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