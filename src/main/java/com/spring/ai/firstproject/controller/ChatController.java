package com.spring.ai.firstproject.controller;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class ChatController {

    private ChatClient openAiChatClient;

    public ChatController(@Qualifier("openAiChatClient") ChatClient openAiChatClient) {
        this.openAiChatClient = openAiChatClient;
    }

    // public ChatController(ChatClient.Builder builder) {
    // this.chatClient = builder.build();
    // }

    @GetMapping("/chat")
    public ResponseEntity<String> chat(@RequestParam(value = "q", required = true) String q) {
        var resultResp = openAiChatClient.prompt(q).call().content();
        return ResponseEntity.ok(resultResp);
    }
}
