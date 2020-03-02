package com.github.fairit.be_doyou_destinypro;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
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
}
