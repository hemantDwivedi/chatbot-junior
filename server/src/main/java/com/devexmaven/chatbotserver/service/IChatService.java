package com.devexmaven.chatbotserver.service;

import com.devexmaven.chatbotserver.dto.request.ChatQuery;
import com.devexmaven.chatbotserver.model.Chat;

import java.util.List;

public interface IChatService {
    Chat createChat(ChatQuery chatQuery);
    List<Chat> getAllChats();
}
