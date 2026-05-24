package com.shubham.GenAiP04.controller;


import com.google.genai.Chat;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class StudentController {

    private final ChatClient chatClient;

    public StudentController(ChatClient chatClient){

        this.chatClient = chatClient;
    }

    @GetMapping("/query")
    public String courseQuery(@RequestParam String msg){

        return chatClient
                .prompt()
                .user(msg)
                .call()
                .content();
    }
}
