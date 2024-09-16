package org.library.auth_service.config;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class AuthorAppConfig {

    @Value("${addressservice.base.url}")
    private String addressBaseURL;
    @Bean
    public ModelMapper modelMapper(){
        return  new ModelMapper();
    }
@Bean
public WebClient webClient(){
        return WebClient
                .builder()
                .baseUrl(addressBaseURL)
                .build();
}
//    @Bean
//    public RestTemplate restTemplate(){
//        return new RestTemplate();
//    }
}
