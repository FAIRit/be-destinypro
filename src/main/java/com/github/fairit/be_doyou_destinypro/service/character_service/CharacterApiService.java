package com.github.fairit.be_doyou_destinypro.service.character_service;

import com.github.fairit.be_doyou_destinypro.config.HttpConfig;
import com.github.fairit.be_doyou_destinypro.dto.character.CharacterApi;
import com.github.fairit.be_doyou_destinypro.dto.character.CharacterData;
import com.github.fairit.be_doyou_destinypro.dto.player.api.PlayerApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class CharacterApiService {

    private RestTemplate restTemplate;
    private HttpConfig httpConfig;

    @Value("${api.bungie.address.listofcharacters}")
    private String charactersApiAddress;

    @Autowired
    public CharacterApiService(final RestTemplate restTemplate, final HttpConfig httpConfig) {
        this.restTemplate = restTemplate;
        this.httpConfig = httpConfig;
    }

    public List<Object> showListOfPlayerCharacters(PlayerApi playerApi) {

        String addressURL = getCorrectCharacterApiAddress(playerApi);
        ResponseEntity<CharacterApi> exchange = restTemplate
                .exchange(addressURL, HttpMethod.GET, httpConfig.getHttpEntity(), CharacterApi.class, 1);

        CharacterApi characterApi = exchange.getBody();
        Map<Object, CharacterData> characterData = null;
        if (characterApi != null) {
            characterData = characterApi.getResponse().getCharacter().getCharacterData();
        }
        if (characterData != null) {
            return new ArrayList<>(characterData.keySet());
        }
        throw new RuntimeException("Problem with reading characters list");
    }

    private String getCorrectCharacterApiAddress(final PlayerApi playerApi) {
        String membershipId = playerApi.getResponse().get(0).getMembershipId();
        Byte membershipType = playerApi.getResponse().get(0).getMembershipType();

        return charactersApiAddress
                .replace("{membershipType}", membershipType.toString())
                .replace("{membershipId}", membershipId);
    }
}
