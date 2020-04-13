package com.github.fairit.destinypro.service.impl.player;

import com.github.fairit.destinypro.dto.player.api.PlayerApi;
import com.github.fairit.destinypro.exception.BadPlayerRequestException;
import com.github.fairit.destinypro.exception.PlayerNotFoundException;
import com.github.fairit.destinypro.service.player.PlayerApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Objects;

@Service
public class PlayerApiServiceImpl implements PlayerApiService {

    private final RestTemplate restTemplate;
    private final HttpEntity<?> httpEntity;

    @Value("${api.bungie.address.player}")
    private String playerApiAddress;

    @Autowired
    public PlayerApiServiceImpl(final RestTemplate restTemplate, final HttpEntity<?> httpEntity) {
        this.restTemplate = restTemplate;
        this.httpEntity = httpEntity;
    }

    @Override
    public PlayerApi findPlayerApiByNickname(final String nickname) {
        String addressURL = playerApiAddress.replace("{nickname}", nickname);
        ResponseEntity<PlayerApi> responseEntity = restTemplate
                .exchange(addressURL, HttpMethod.GET, httpEntity, PlayerApi.class, 1);

        if (responseEntity.getStatusCodeValue() != 200
        || Objects.requireNonNull(responseEntity.getBody()).getResponse().isEmpty()) {
            throw new BadPlayerRequestException(nickname);
        } else if (responseEntity.getBody() == null){
            throw new PlayerNotFoundException(nickname);
        }
        return responseEntity.getBody();
    }
}
