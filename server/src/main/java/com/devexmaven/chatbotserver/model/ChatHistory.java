package com.devexmaven.chatbotserver.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class ChatHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer chatHistoryId;

    @JsonProperty("UserFirstQuery")
    @Column(nullable = false)
    private String userFirstQuery;

    @JsonProperty("Chats")
    @OneToMany(cascade = CascadeType.ALL)
    private List<Chat> chats;

    public ChatHistory() {
    }

    public ChatHistory(Integer chatHistoryId, String userFirstQuery, List<Chat> chats) {
        this.chatHistoryId = chatHistoryId;
        this.userFirstQuery = userFirstQuery;
        this.chats = chats;
    }

    public Integer getChatHistoryId() {
        return chatHistoryId;
    }

    public void setChatHistoryId(Integer chatHistoryId) {
        this.chatHistoryId = chatHistoryId;
    }

    public String getUserFirstQuery() {
        return userFirstQuery;
    }

    public void setUserFirstQuery(String userFirstQuery) {
        this.userFirstQuery = userFirstQuery;
    }

    public List<Chat> getChats() {
        return chats;
    }

    public void setChats(List<Chat> chats) {
        this.chats = chats;
    }
}