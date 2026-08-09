package com.spring.ai.firstproject.config;

import java.util.List;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.client.advisor.SafeGuardAdvisor;
import org.springframework.ai.chat.client.advisor.SimpleLoggerAdvisor;
import org.springframework.ai.openai.OpenAiChatModel;
import org.springframework.ai.openai.OpenAiChatOptions;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AiConfig {

    @Bean
    public ChatClient chatClient(ChatClient.Builder builder) {
        return builder
                .defaultAdvisors(new SimpleLoggerAdvisor(), new SafeGuardAdvisor(List.of("game")))
                .defaultSystem("You are a helpful coding assistant, You are the expert in coding")
                .defaultOptions(OpenAiChatOptions.builder()
                        .model("openai/gpt-oss-20b:free")
                        // .model("openai/gpt-oss-120b:free")
                        .temperature(0.3)
                // .maxTokens(100)
                // .maxCompletionTokens(100))
                )
                .build();
    }
    // @Bean("openAiChatClient")
    // public ChatClient openAiChatModel(OpenAiChatModel chatModel) {
    // return ChatClient.builder(chatModel).build();
    // }
}
