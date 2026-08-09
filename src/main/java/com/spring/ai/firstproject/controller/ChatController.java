package com.spring.ai.firstproject.controller;

import java.util.List;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.spring.ai.firstproject.entity.Tut;
import com.spring.ai.firstproject.service.ChatService;
import com.spring.ai.firstproject.service.ChatServiceImpl;

@RestController
@RequestMapping
public class ChatController {

    // private ChatClient openAiChatClient;

    // public ChatController(@Qualifier("openAiChatClient") ChatClient
    // openAiChatClient) {
    // this.openAiChatClient = openAiChatClient;
    // }

    // public ChatController(ChatClient.Builder builder) {
    // this.chatClient = builder.build();
    // }

    private ChatService chatService;

    public ChatController(ChatService chatService) {
        this.chatService = chatService;
    }

    @GetMapping("/chat")
    public ResponseEntity<String> chat(@RequestParam(value = "q", required = true) String q) {
        return ResponseEntity.ok(chatService.chat(q));
    }
    // @GetMapping("/chat")
    // public ResponseEntity<String> chat(@RequestParam(value = "q", required =
    // true) String q) {
    // var resultResp = openAiChatClient.prompt(q).call().content();
    // return ResponseEntity.ok(resultResp);
    // }

    @GetMapping("/chatTut")
    public ResponseEntity<List<Tut>> chatTut(@RequestParam(value = "q", required = true) String q) {
        return ResponseEntity.ok(chatService.chatTut(q));
    }

    @GetMapping("/chatstreaming")
    public ResponseEntity<String> chatStreaming(@RequestParam(value = "q", required = true) String q) {
        return ResponseEntity.ok(chatService.chat(q));
    }

    @GetMapping("/chattemplate")
    public ResponseEntity<String> chatTemplate() {
        return ResponseEntity.ok(chatService.chatTemplate());
    }

    @GetMapping("/promptusingfile")
    public ResponseEntity<String> promptUsingFile() {
        return ResponseEntity.ok(chatService.promptUsingFile());
    }

    // Advisor
    @GetMapping("/chatadvisor")
    public ResponseEntity<String> chatAdvisor(@RequestParam(value = "q", required = true) String q) {
        return ResponseEntity.ok(chatService.chatAdvisor(q));
    }
}
