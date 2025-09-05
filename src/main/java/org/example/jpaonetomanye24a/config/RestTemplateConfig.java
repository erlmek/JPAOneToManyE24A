package org.example.jpaonetomanye24a.config;


import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTemplateConfig {

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder restTemplateBuilder) {
        System.out.println("builder en restTemplate");
        RestTemplate rtp = restTemplateBuilder.build();
        return rtp;
    }



}
