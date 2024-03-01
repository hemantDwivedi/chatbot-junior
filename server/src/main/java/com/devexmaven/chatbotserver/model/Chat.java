package com.devexmaven.chatbotserver.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

@Entity
public class Chat {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonProperty("ChatId")
    private Integer chatId;
    @JsonProperty("Query")
    @Column(nullable = false)
    private String userQuery;
    @JsonProperty("Answer")
    @Column(nullable = false)
    private String chatbotAnswer;
}
