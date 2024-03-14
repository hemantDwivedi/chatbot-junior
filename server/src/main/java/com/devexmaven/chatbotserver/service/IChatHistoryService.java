package com.devexmaven.chatbotserver.service;

import com.devexmaven.chatbotserver.dto.response.ChatHistoryDTO;

import java.util.List;

public interface IChatHistoryService {
    ChatHistoryDTO createChatHistory(Integer chatID);
    List<ChatHistoryDTO> getAllChatHistories();
    ChatHistoryDTO updateChatHistory(Integer chatHistoryId, Integer chatId);
}
