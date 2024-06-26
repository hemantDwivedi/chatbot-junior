package com.devexmaven.chatbotserver.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "chat_histories")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ChatHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ch_id")
    @JsonProperty("ChatHistoryId")
    private Integer chatHistoryId;

    @JsonProperty("UserFirstQuery")
    @Column(nullable = false)
    private String userFirstQuery;

    @JsonProperty("Chats")
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @Column(nullable = false)
    private List<Chat> chats;
}