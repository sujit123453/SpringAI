package com.spring.ai.IntegratingOpenAI.service;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneId;

@Service
public class ChatService {

    private final ChatClient chatClient;

    public ChatService(ChatClient.Builder chatClient) {
        this.chatClient = chatClient.build();
    }

    public String chat(String s) {

        ZoneId zone = ZoneId.of("Asia/Kolkata");

        LocalDateTime currentDateTime = LocalDateTime.now(zone);

        String prompt = """
                Current date and time: %s
                Timezone: Asia/Kolkata

                User question:
                %s
                """.formatted(currentDateTime, s);

        return chatClient
                .prompt()
                .user(prompt)
                .call()
                .content();
    }
}