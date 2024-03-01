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
}
