package com.github.fairit.destinypro.service.player;

import com.github.fairit.destinypro.config.ApplicationConfig;
import com.github.fairit.destinypro.dto.playerapi.PlayerApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class PlayerApiService {

    private final RestTemplate restTemplate;
    private final ApplicationConfig httpConfig;

    @Value("${api.bungie.address.player}")
    private String playerApiAddress;

    @Autowired
    public PlayerApiService(final RestTemplate restTemplate, final ApplicationConfig httpConfig) {
        this.restTemplate = restTemplate;
        this.httpConfig = httpConfig;
    }

    public PlayerApi findPlayerApiByNickname(final String nickname) {
            String addressURL = playerApiAddress.replace("{nickname}", nickname);
            return restTemplate
                    .exchange(addressURL, HttpMethod.GET, httpConfig.getHttpEntity(), PlayerApi.class, 1)
                    .getBody();
    }
}
