package com.spring.ai.firstproject.service;

import java.util.List;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;

import com.spring.ai.firstproject.entity.Tut;

@Service
public class ChatServiceImpl implements ChatService {

    private ChatClient chatClient;

    public ChatServiceImpl(ChatClient.Builder builder) {
        this.chatClient = builder.build();
    }

    @Override
    public String chat(String query) {
        String prompt = "Tell me about virat Kohli in 30 words";
        // var content = chatClient.prompt()
        // .user(prompt)
        // .system("As a expert in cricket")
        // .call()
        // .content();

        Prompt prompt1 = new Prompt(query);

        var content = chatClient
                .prompt(prompt1)
                .call()
                .chatResponse()
                .getResult()
                .getOutput()
                .getText();

        System.out.println(content);
        return content;

    }

    @Override
    public List<Tut> chatTut(String query) {
        Prompt prompt1 = new Prompt(query);

        List<Tut> tutorial = chatClient
                .prompt(prompt1)
                .call()
                .entity(new ParameterizedTypeReference<List<Tut>>() {

                });
        return tutorial;
    }

}
