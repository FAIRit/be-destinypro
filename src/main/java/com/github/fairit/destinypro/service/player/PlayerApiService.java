package com.github.fairit.destinypro.service.player;

import com.github.fairit.destinypro.config.ApplicationConfig;
import com.github.fairit.destinypro.dto.playerapi.PlayerApi;
import com.github.fairit.destinypro.exception.BadPlayerRequestException;
import com.github.fairit.destinypro.exception.PlayerNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Objects;

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
        ResponseEntity<PlayerApi> responseEntity = restTemplate
                .exchange(addressURL, HttpMethod.GET, httpConfig.getHttpEntity(), PlayerApi.class, 1);

        if (responseEntity.getStatusCodeValue() != 200
        || Objects.requireNonNull(responseEntity.getBody()).getResponse().isEmpty()) {
            throw new BadPlayerRequestException(nickname);
        } else if (responseEntity.getBody() == null){
            throw new PlayerNotFoundException(nickname);
        }
        return responseEntity.getBody();
    }
}
