package com.github.fairit.be_doyou_destinypro.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;

@Configuration
public class HttpConfig {

    private HttpHeaders httpHeaders;

    public HttpConfig(final HttpHeaders httpHeaders) {
        this.httpHeaders = httpHeaders;
    }

    public HttpEntity getHttpEntity() {
        httpHeaders.set("x-api-key", "188bb3eb49644d198f0111661ebb8f69");
        return new HttpEntity(httpHeaders);
    }
}
