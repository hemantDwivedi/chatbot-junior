package com.devexmaven.chatbotserver.repository;

import com.devexmaven.chatbotserver.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}