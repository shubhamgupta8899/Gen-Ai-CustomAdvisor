package com.shubham.GenAiP04.config;

import com.shubham.GenAiP04.advisor.CustomAdvisor;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.client.advisor.SimpleLoggerAdvisor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ChatClientConfig {

    @Bean
    public ChatClient chatClient(ChatClient.Builder chatClientBuilder){

        return chatClientBuilder
                .defaultSystem("""
                        You are helpful spring Ai tuitor 
                        Answer in short and simple with short example
                        """)
                .defaultAdvisors(new CustomAdvisor())
                .build();
    }
}
