package com.devexmaven.chatbotserver.controller;

import com.devexmaven.chatbotserver.dto.request.ChatDTO;
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
    public ResponseEntity<ChatDTO> createChat(@RequestBody ChatDTO chatDTO){
        return new ResponseEntity<>(chatService.createChat(chatDTO), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<ChatDTO>> getAllChats(){
        return new ResponseEntity<>(chatService.getAllChats(), HttpStatus.OK);
    }
}
