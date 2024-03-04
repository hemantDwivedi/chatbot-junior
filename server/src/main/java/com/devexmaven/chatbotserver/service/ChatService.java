package com.devexmaven.chatbotserver.service;

import com.devexmaven.chatbotserver.dto.request.ChatDTO;
import com.devexmaven.chatbotserver.model.Chat;
import com.devexmaven.chatbotserver.repository.ChatRepository;
import com.devexmaven.chatbotserver.utils.MapperHelper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ChatService implements IChatService{
    private final ChatRepository chatRepository;
    private final MapperHelper mapper;

    public ChatService(ChatRepository chatRepository, MapperHelper mapper) {
        this.chatRepository = chatRepository;
        this.mapper = mapper;
    }

    @Override
    public ChatDTO createChat(ChatDTO chatDTO) {
        Chat chat = mapper.chatDtoToChat(chatDTO);
        Chat savedChat = chatRepository.save(chat);
        return mapper.chatToChatDto(savedChat);
    }

    @Override
    public List<ChatDTO> getAllChats() {
        return chatRepository
                .findAll()
                .stream()
                .map(chat -> mapper.chatToChatDto(chat))
                .collect(Collectors.toList());
    }
}
