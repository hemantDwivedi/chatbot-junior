package com.devexmaven.chatbotserver.repository;

import com.devexmaven.chatbotserver.model.ChatHistory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChatHistoryRepository extends JpaRepository<ChatHistory, Integer> {
}