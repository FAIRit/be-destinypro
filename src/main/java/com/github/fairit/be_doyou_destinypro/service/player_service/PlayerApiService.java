package com.github.fairit.be_doyou_destinypro.service.player_service;

import com.github.fairit.be_doyou_destinypro.dto.player.api.PlayerApi;
import com.github.fairit.be_doyou_destinypro.dto.player.api.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;

@Service
public class PlayerApiService {

    private RestTemplate restTemplate;

    @Value("${api.bungie.address.player}")
    private String currentApiAddress;

    @Autowired
    public PlayerApiService(final RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public PlayerApi findPlayerApiByNickname (String nickname){

        String addressURL = currentApiAddress.replace("{nickname}", nickname);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));

        headers.set("x-api-key","188bb3eb49644d198f0111661ebb8f69");
        HttpEntity request = new HttpEntity(headers);

        ResponseEntity<PlayerApi> exchange = restTemplate.exchange(addressURL, HttpMethod.GET, request, PlayerApi.class, 1);
        PlayerApi body = exchange.getBody();

        return body;
    }
}
