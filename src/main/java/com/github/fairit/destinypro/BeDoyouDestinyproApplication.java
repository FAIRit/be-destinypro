package com.github.fairit.destinypro;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpHeaders;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class BeDoyouDestinyproApplication {

    public static void main(String[] args) {
        SpringApplication.run(BeDoyouDestinyproApplication.class, args);
    }

    @Bean
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }

   @Bean
    public HttpHeaders getHttpHeaders() {
        return new HttpHeaders();
    }
    @Bean
    public ModelMapper getModelMapper() {
        return new ModelMapper();
    }
}
