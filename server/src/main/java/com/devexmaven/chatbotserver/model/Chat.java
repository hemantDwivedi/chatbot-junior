package com.devexmaven.chatbotserver.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "chats")
@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Chat {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonIgnore
    @Column(name = "chat_id")
    private Integer chatId;
    @JsonProperty("Query")
    @Column(nullable = false)
    private String query;
    @JsonProperty("Answer")
    @Column(nullable = false)
    private String answer;
}