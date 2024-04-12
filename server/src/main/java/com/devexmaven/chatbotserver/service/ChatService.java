package com.devexmaven.chatbotserver.service;

import com.devexmaven.chatbotserver.dto.request.ChatQuery;
import com.devexmaven.chatbotserver.model.Chat;
import com.devexmaven.chatbotserver.repository.ChatRepository;
import com.devexmaven.chatbotserver.utils.MapperHelper;
import lombok.AllArgsConstructor;
import org.springframework.ai.chat.ChatClient;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ChatService implements IChatService{
    private final ChatClient chatClient;
    private final ChatRepository chatRepository;
    private final MapperHelper mapper;

    @Override
    public Chat createChat(ChatQuery chatQuery) {

        Prompt prompt = new Prompt(chatQuery.getQuery());
        String content = chatClient.call(prompt).getResult().getOutput().getContent();

        Chat chat = Chat.builder().query(chatQuery.getQuery()).answer(content).build();

        return chat;
    }

    @Override
    public List<ChatQuery> getAllChats() {
        return chatRepository
                .findAll()
                .stream()
                .map(chat -> mapper.chatToChatDto(chat))
                .collect(Collectors.toList());
    }
}
