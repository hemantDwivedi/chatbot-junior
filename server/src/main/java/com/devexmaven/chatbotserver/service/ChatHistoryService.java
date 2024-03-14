package com.devexmaven.chatbotserver.service;

import com.devexmaven.chatbotserver.dto.response.ChatHistoryDTO;
import com.devexmaven.chatbotserver.exception.ResourceNotFoundException;
import com.devexmaven.chatbotserver.model.Chat;
import com.devexmaven.chatbotserver.model.ChatHistory;
import com.devexmaven.chatbotserver.repository.ChatHistoryRepository;
import com.devexmaven.chatbotserver.repository.ChatRepository;
import com.devexmaven.chatbotserver.utils.MapperHelper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ChatHistoryService implements IChatHistoryService {
    private final ChatHistoryRepository chatHistoryRepository;
    private final ChatRepository chatRepository;
    private final MapperHelper mapperHelper;

    public ChatHistoryService(ChatHistoryRepository chatHistoryRepository, ChatRepository chatRepository, MapperHelper mapperHelper) {
        this.chatHistoryRepository = chatHistoryRepository;
        this.chatRepository = chatRepository;
        this.mapperHelper = mapperHelper;
    }

    @Override
    public ChatHistoryDTO createChatHistory(Integer chatId) {
        ChatHistory chatHistory = new ChatHistory();
        Chat chat = chatRepository.findById(chatId)
                .orElseThrow(() -> new ResourceNotFoundException("Chat not found with ID:" + chatId));
        ArrayList<Chat> chats = new ArrayList<>();
        chats.add(chat);
        chatHistory.setChats(chats);
        chatHistory.setUserFirstQuery(chat.getQuery());
        ChatHistory savedHistory = chatHistoryRepository.save((chatHistory));
        return mapperHelper.chatHistoryToChatHistoryDto(savedHistory);
    }

    @Override
    public List<ChatHistoryDTO> getAllChatHistories() {
        List<ChatHistory> chatHistories = chatHistoryRepository.findAll();
        return mapperHelper.chatHistoryListToChatHistoryDtoList(chatHistories);
    }

    @Override
    public ChatHistoryDTO updateChatHistory(Integer chatHistoryId, Integer chatId) {
        ChatHistory chatHistory = chatHistoryRepository.findById(chatHistoryId)
                .orElseThrow(() -> new ResourceNotFoundException("Chat history not found with ID:" + chatHistoryId));
        Chat chat = chatRepository.findById(chatId)
                .orElseThrow(() -> new ResourceNotFoundException("Chat not found with ID:" + chatId));
        List<Chat> chats = chatHistory.getChats();
        chats.add(chat);
        chatHistory.setChats(chats);
        ChatHistory savedHistory = chatHistoryRepository.save(chatHistory);
        return mapperHelper.chatHistoryToChatHistoryDto(savedHistory);
    }
}
