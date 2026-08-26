package com.spring.ai.IntegratingOpenAI.service;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneId;

@Service
public class ChatService {

    private final ChatClient openAiChatClient;
    private final ChatClient ollamaChatClient;

    public ChatService(@Qualifier("OpenAiChatModel") ChatClient openAiChatClient,
                       @Qualifier("OllamaChatModel") ChatClient ollamaChatClient){
        this.openAiChatClient = openAiChatClient;
        this.ollamaChatClient = ollamaChatClient;
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

        return ollamaChatClient
                .prompt()
                .user(prompt)
                .call()
                .content();
    }
}