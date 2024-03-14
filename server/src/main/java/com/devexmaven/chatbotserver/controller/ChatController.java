package com.devexmaven.chatbotserver.controller;

import com.devexmaven.chatbotserver.dto.request.ChatQuery;
import com.devexmaven.chatbotserver.model.Chat;
import com.devexmaven.chatbotserver.service.IChatService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/chats")
public class ChatController {
    private final IChatService chatService;

    public ChatController(IChatService chatService) {
        this.chatService = chatService;
    }

    @PostMapping
    public ResponseEntity<Chat> createChat(@RequestBody ChatQuery chatQuery){
        return new ResponseEntity<>(chatService.createChat(chatQuery), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<ChatQuery>> getAllChats(){
        return new ResponseEntity<>(chatService.getAllChats(), HttpStatus.OK);
    }
}
