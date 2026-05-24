package com.shubham.GenAiP04.controller;

import com.shubham.GenAiP04.advisor.CustomAdvisor;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.client.ChatClientResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/custom")
public class CustomAdvisorController {

    private final ChatClient chatClient;

    public CustomAdvisorController(ChatClient chatClient){

        this.chatClient = chatClient;
    }

    @GetMapping
    public CustomAdvisorResponse query(@RequestParam String msg){

        ChatClientResponse res = chatClient.prompt()
                .user(msg)
                .advisors(new CustomAdvisor())
                .call()
                .chatClientResponse();

        return new CustomAdvisorResponse(res.chatResponse().getResult().getOutput().getText(), "custom",
            res.context().get(CustomAdvisor.END_TIME_NANO));

    }

    public record CustomAdvisorResponse(String res, String advisorUsed, Object endTime){

    }
}
