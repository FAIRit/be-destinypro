package com.github.fairit.be_doyou_destinypro.service.player_service;

import com.github.fairit.be_doyou_destinypro.config.HttpConfig;
import com.github.fairit.be_doyou_destinypro.dto.player.api.PlayerApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class PlayerApiService {

    private RestTemplate restTemplate;
    private HttpConfig httpConfig;

    @Value("${api.bungie.address.player}")
    private String playerApiAddress;

    @Autowired
    public PlayerApiService(final RestTemplate restTemplate, final HttpConfig httpConfig) {
        this.restTemplate = restTemplate;
        this.httpConfig = httpConfig;
    }

    public PlayerApi findPlayerApiByNickname(String nickname) {

        String addressURL = playerApiAddress.replace("{nickname}", nickname);
        ResponseEntity<PlayerApi> exchange = restTemplate
                .exchange(addressURL, HttpMethod.GET, httpConfig.getHttpEntity(), PlayerApi.class, 1);
        return exchange.getBody();
    }
}
