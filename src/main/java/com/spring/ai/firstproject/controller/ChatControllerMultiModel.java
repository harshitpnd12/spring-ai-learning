package com.spring.ai.firstproject.controller;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.openai.OpenAiChatModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class ChatControllerMultiModel {

    private ChatClient openAiChatClient;
    private ChatClient geminiChatClient;

    // public ChatControllerMultiModel(OpenAiChatModel openAiChatModel,
    // GeminiAiChatModel geminiChatClient) {
    // this.openAiChatClient = ChatClient.builder(openAiChatModel).build();
    // this.geminiChatClient = ChatClient.builder(geminiChatClient).build();
    // }

    // @GetMapping("/chat")
    // public ResponseEntity<String> chat(@RequestParam(value = "q", required =
    // true) String q) {
    // var resultResp = openAiChatClient.prompt(q).call().content();
    // return ResponseEntity.ok(resultResp);
    // }

}
