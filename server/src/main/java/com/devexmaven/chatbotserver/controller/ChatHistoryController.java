package com.devexmaven.chatbotserver.controller;

import com.devexmaven.chatbotserver.dto.response.ChatHistoryDTO;
import com.devexmaven.chatbotserver.service.IChatHistoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/chats/histories")
public class ChatHistoryController {
    private final IChatHistoryService chatHistoryService;

    public ChatHistoryController(IChatHistoryService chatHistoryService) {
        this.chatHistoryService = chatHistoryService;
    }

    @PostMapping
    public ResponseEntity<ChatHistoryDTO> createChatHistory(@RequestParam Integer chatId){
        return new ResponseEntity<>(chatHistoryService.createChatHistory(chatId), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<ChatHistoryDTO>> getAllChatHistories(){
        return new ResponseEntity<>(chatHistoryService.getAllChatHistories(), HttpStatus.OK);
    }

    @PutMapping("/{chatHistoryId}")
    public ResponseEntity<ChatHistoryDTO> createChatHistory(@PathVariable Integer chatHistoryId, @RequestParam Integer chatId){
        return new ResponseEntity<>(chatHistoryService.updateChatHistory(chatHistoryId, chatId), HttpStatus.CREATED);
    }
}
