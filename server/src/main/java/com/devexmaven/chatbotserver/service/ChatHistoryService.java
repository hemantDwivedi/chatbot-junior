package com.devexmaven.chatbotserver.service;

import com.devexmaven.chatbotserver.dto.response.ChatHistoryDTO;
import com.devexmaven.chatbotserver.exception.ResourceNotFoundException;
import com.devexmaven.chatbotserver.model.Chat;
import com.devexmaven.chatbotserver.model.ChatHistory;
import com.devexmaven.chatbotserver.repository.ChatHistoryRepository;
import com.devexmaven.chatbotserver.repository.ChatRepository;
import com.devexmaven.chatbotserver.utils.MapperHelper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class ChatHistoryService implements IChatHistoryService {
    private final ChatHistoryRepository chatHistoryRepository;
    private final ChatRepository chatRepository;
    private final MapperHelper mapperHelper;

    @Override
    public ChatHistoryDTO createChatHistory(Integer chatId) {
        Chat chat = chatRepository.findById(chatId)
                .orElseThrow(() -> new ResourceNotFoundException("Chat not found with ID:" + chatId));
        ArrayList<Chat> chats = new ArrayList<>();
        chats.add(chat);

        ChatHistory chatHistory = ChatHistory.builder().chats(chats).userFirstQuery(chat.getQuery()).build();
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
