package com.devexmaven.chatbotserver.model;

import jakarta.persistence.*;

@Entity
@Table(name = "users_tb")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long userId;
}
