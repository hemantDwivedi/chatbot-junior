package com.devexmaven.chatbotserver.repository;

import com.devexmaven.chatbotserver.model.Chat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChatRepository extends JpaRepository<Chat, Integer> {
}
