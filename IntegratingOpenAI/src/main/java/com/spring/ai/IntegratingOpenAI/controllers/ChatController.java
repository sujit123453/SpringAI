package com.spring.ai.IntegratingOpenAI.controllers;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/chat")
public class ChatController {

    private ChatClient chatClient;

    public ChatController(ChatClient.Builder builder){
        this.chatClient = builder.build();
    }

    @GetMapping()
    public ResponseEntity<String> chat(@RequestParam(value = "q", required = true) String s){
        String response = chatClient.prompt(s).call().content();
        return ResponseEntity.ok(response);
    }
}
