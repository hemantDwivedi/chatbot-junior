package com.devexmaven.chatbotserver.utils;

import com.devexmaven.chatbotserver.dto.request.ChatDTO;
import com.devexmaven.chatbotserver.dto.request.UserRequest;
import com.devexmaven.chatbotserver.dto.response.ChatHistoryDTO;
import com.devexmaven.chatbotserver.dto.response.UserResponse;
import com.devexmaven.chatbotserver.model.Chat;
import com.devexmaven.chatbotserver.model.ChatHistory;
import com.devexmaven.chatbotserver.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface MapperHelper {
    MapperHelper INSTANCE = Mappers.getMapper(MapperHelper.class);

    User userRequestToUser(UserRequest userRequest);
    UserResponse userToUserResponse(User user);
    User updateEntity(@MappingTarget User user, UserRequest userRequest);

    Chat chatDtoToChat(ChatDTO chatDTO);
    ChatDTO chatToChatDto(Chat chat);

    ChatHistory chatHistoryDtoToChatHistory(ChatHistoryDTO chatHistoryDTO);
    ChatHistoryDTO chatHistoryToChatHistoryDto(ChatHistory chatHistory);
    List<ChatHistoryDTO> chatHistoryListToChatHistoryDtoList(List<ChatHistory> chatHistories);
}