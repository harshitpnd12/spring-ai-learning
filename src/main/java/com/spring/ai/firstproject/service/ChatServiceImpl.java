package com.spring.ai.firstproject.service;

import java.util.List;
import java.util.Map;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.chat.prompt.PromptTemplate;
import org.springframework.ai.chat.prompt.SystemPromptTemplate;
import org.springframework.ai.openai.OpenAiChatOptions;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import com.spring.ai.firstproject.entity.Tut;

@Service
public class ChatServiceImpl implements ChatService {

    private ChatClient chatClient;

    public ChatServiceImpl(ChatClient chatClient) {
        this.chatClient = chatClient;
    }

    @Override
    public String chat(String query) {
        String prompt = "Tell me about virat Kohli in 30 words";
        // var content = chatClient.prompt()
        // .user(prompt)
        // .system("As a expert in cricket")
        // .call()
        // .content();

        // Prompt prompt1 = new Prompt(query);

        // var content = chatClient
        // .prompt(prompt1)
        // .call()
        // .chatResponse()
        // .getResult()
        // .getOutput()
        // .getText();

        // Prompt prompt1 = new Prompt(query, OpenAiChatOptions.builder()
        // .model("openai/gpt-oss-120b:free")
        // .temperature(0.2)
        // .maxTokens(100)
        // .build());

        Prompt prompt1 = new Prompt(query);

        String queryStr = "As an expert in coding and programming. Always write program in java. Now reply for this question :{query}";

        try {
            return chatClient
                    .prompt()
                    .user(u -> u.text(queryStr).param("query", query))
                    .call()
                    .content();
        } catch (Exception e) {
            e.printStackTrace();
            return "AI service is temporarily unavailable. Please try again later." + e;
        }

        // System.out.println(content);
        // return content;

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

    public String chatTemplate() {
        // first step Prompt template
        // PromptTemplate strTemplate = PromptTemplate
        // .builder()
        // .template("what is {techname}? tell me example of {exampleName} in 30 words")
        // .build();

        // // Second Step Render
        // String renderMessage = strTemplate.render(Map.of(
        // "techname", "spring",
        // "exampleName", "spring Boot"));

        // // third Step
        // Prompt prompt = new Prompt(renderMessage);

        // var systemPromptTemplate = SystemPromptTemplate.builder()
        // .template("You are a helpful coding assitant.You are an expert in coding.")
        // .build();

        // var systemMessage = systemPromptTemplate.createMessage();

        // var userPromptTemplate = PromptTemplate
        // .builder()
        // .template("what is {techname}? tell me example of {exampleName} in 100
        // words")
        // .build();

        // var userMessage = userPromptTemplate.createMessage(Map.of(
        // "techname", "spring",
        // "exampleName", "spring exception"));

        // Prompt prompt = new Prompt(systemMessage, userMessage);

        // // Fourth Step
        // try {
        // return this.chatClient
        // .prompt(prompt)
        // .call()
        // .content();
        // // return this.chatClient
        // // .prompt(prompt)
        // // .call()
        // // .content();
        // } catch (Exception e) {
        // e.printStackTrace();
        // return "Chat Template AI service Band h. Error: " + e.getMessage();
        // }

        // this method using fluent api

        return this.chatClient
                .prompt()
                .system(system -> system.text("You are a helpful coding assitant.You are an expert in coding."))
                .user(user -> user.text("what is {techname}? tell me example of {exampleName}")
                        .param("techname", "spring")
                        .param("exampleName", "spring exception"))
                .call()
                .content();
    }

    @Value("classpath:/prompt/user-message.st")
    private Resource userMessage;

    @Value("classpath:/prompt/system-prompt.st")
    private Resource systemMessage;

    public String promptUsingFile() {
        return this.chatClient
                .prompt()
                .system(system -> system.text(this.systemMessage))
                .user(user -> user.text(this.userMessage).param("concept", "java iteration"))
                .call()
                .content();
    }

}
