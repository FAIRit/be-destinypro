package com.github.fairit.destinypro.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ApplicationConfig {

    private final HttpHeaders httpHeaders;

    public ApplicationConfig(final HttpHeaders httpHeaders) {
        this.httpHeaders = httpHeaders;
    }

    public HttpEntity getHttpEntity() {
        httpHeaders.set("x-api-key", "188bb3eb49644d198f0111661ebb8f69");
        return new HttpEntity(httpHeaders);
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
