package com.devexmaven.chatbotserver.service;

import com.devexmaven.chatbotserver.dto.request.ChatDTO;

import java.util.List;

public interface IChatService {
    ChatDTO createChat(ChatDTO chatDTO);
    List<ChatDTO> getAllChats();
}
