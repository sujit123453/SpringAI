package com.spring.ai.IntegratingOpenAI.service;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.ollama.OllamaChatModel;
import org.springframework.ai.openai.OpenAiChatModel;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneId;

@Service
public class ChatService {

    private final ChatClient openAiChatClient;
    private final ChatClient ollamaChatClient;

    public ChatService(OpenAiChatModel openAiChatModel, OllamaChatModel ollamaChatModel) {
       this.openAiChatClient = ChatClient.builder(openAiChatModel).build();
       this.ollamaChatClient = ChatClient.builder(ollamaChatModel).build();
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