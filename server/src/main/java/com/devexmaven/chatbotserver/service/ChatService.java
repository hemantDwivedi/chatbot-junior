package com.devexmaven.chatbotserver.service;

import com.devexmaven.chatbotserver.dto.request.ChatQuery;
import com.devexmaven.chatbotserver.model.Chat;
import com.devexmaven.chatbotserver.repository.ChatRepository;
import com.devexmaven.chatbotserver.utils.MapperHelper;
import dev.langchain4j.model.openai.OpenAiChatModel;
import org.springframework.stereotype.Service;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Properties;
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
    public Chat createChat(ChatQuery chatQuery) {
        String openaiAnswer = openaiChat(chatQuery.getQuery());
        Chat chat = new Chat();
        chat.setQuery(chatQuery.getQuery());
        chat.setAnswer(openaiAnswer);
        Chat savedChat = chatRepository.save(chat);
        return savedChat;
//        return chat;
    }

    @Override
    public List<ChatQuery> getAllChats() {
        return chatRepository
                .findAll()
                .stream()
                .map(chat -> mapper.chatToChatDto(chat))
                .collect(Collectors.toList());
    }

    private String openaiChat(String query){
        OpenAiChatModel openAiChatModel = OpenAiChatModel.withApiKey(getOpenaiKey());
        return openAiChatModel.generate(query);
    }

    private String getOpenaiKey(){
        Properties properties = new Properties();
        InputStream inputStream;
        try {
            inputStream = new FileInputStream(".env");
            properties.load(inputStream);
        } catch (IOException e){
            throw new RuntimeException(e.getMessage());
        }
        return properties.getProperty("OPENAI_KEY");
    }
}
