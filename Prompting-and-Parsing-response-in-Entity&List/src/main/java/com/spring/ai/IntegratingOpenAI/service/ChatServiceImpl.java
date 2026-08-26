package com.spring.ai.IntegratingOpenAI.service;

import com.spring.ai.IntegratingOpenAI.entity.Tut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChatServiceImpl  implements  ChatService{

    private static final Logger log = LoggerFactory.getLogger(ChatServiceImpl.class);
    private final ChatClient chatClient;

   public ChatServiceImpl(ChatClient.Builder chatClient){
       this.chatClient = chatClient.build();
   }

    @Override
    public List<Tut> chat(String s) {
//       String prompt = "Who was invented Java programming language? give me how he invented and when he invented";
//        String querry = "give me code of prime number in java";

//        return chatClient
//                .prompt()
//                .user(prompt)
//                .system("Please provide a detailed answer to the user's question, including relevant historical context and any notable contributions.")
//                .call()
//                .content();

//        return chatClient
//                .prompt("what is prime number")
//                .system("As a expert programmer")
//                .call().content();

          Prompt prompt1 = new Prompt(s);
//          return chatClient
//                  .prompt(prompt1)
//                  .call().content();




        // this is for getting metadata from the response,
        // but it is commented out because it may not be supported in all chat clients or may require additional configuration.
//        var metaData = chatClient
//                .prompt(prompt1)
//                .call()
//                .chatResponse()
//                .getMetadata();
//        log.info("Metadata: {}", metaData)
//        return "";

        // this is for obtaining actual response
//        var content = chatClient
//                .prompt(s)
//                .call()
//                .chatResponse()
//                .getResult()
//                .getOutput()
//                .getText();
//
//        log.info("Response: {}", content);
//        return content;

//          Tut content =  chatClient
//                .prompt(s)
//                .call()
//                .entity(Tut.class);
//          return  content;

        //if I want list of tut
        List<Tut> tutorials = chatClient
                .prompt(prompt1)
                .call()
                .entity(new ParameterizedTypeReference<List<Tut>>() {
                });


        return tutorials;
    }
}