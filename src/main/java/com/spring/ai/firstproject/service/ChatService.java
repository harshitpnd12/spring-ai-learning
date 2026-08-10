package com.spring.ai.firstproject.service;

import java.util.List;

import com.spring.ai.firstproject.entity.Tut;

import reactor.core.publisher.Flux;

public interface ChatService {

    String chat(String query);

    List<Tut> chatTut(String query);

    String chatTemplate();

    String promptUsingFile();

    String chatAdvisor(String query);

    Flux<String> streamChat(String query);
}
