package com.spring.ai.IntegratingOpenAI.controllers;

import com.spring.ai.IntegratingOpenAI.entity.Tut;
import com.spring.ai.IntegratingOpenAI.service.ChatService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping
public class ChatController {
   private final ChatService chatService;

   public ChatController(ChatService chatService){
       this.chatService = chatService;
   }

    @GetMapping("/chat")
    public ResponseEntity<List<Tut>> chat(@RequestParam(value = "q", required = true) String s){
        return  ResponseEntity.ok(chatService.chat(s));
    }

}
