package com.github.fairit.destinypro.service.character_service;

import com.github.fairit.destinypro.config.HttpConfig;
import com.github.fairit.destinypro.dto.characters.api.AllCharactersApiData;
import com.github.fairit.destinypro.dto.characters.api.AllCharactersApiResponse;
import com.github.fairit.destinypro.dto.player.api.PlayerApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

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

    public Map<Object, AllCharactersApiData> showListOfPlayerCharacters(PlayerApi playerApi) {

        String addressURL = getCorrectCharacterApiAddress(playerApi);
        ResponseEntity<AllCharactersApiResponse> exchange = restTemplate
                .exchange(addressURL, HttpMethod.GET, httpConfig.getHttpEntity(), AllCharactersApiResponse.class, 1);

        AllCharactersApiResponse characterApi = exchange.getBody();

        if (characterApi != null) {
            return characterApi.getResponse().getCharacter().getCharacterData();
        }
        throw new RuntimeException("Problem with reading characters map");
    }

    private String getCorrectCharacterApiAddress(final PlayerApi playerApi) {
        String membershipId = playerApi.getResponse().get(0).getMembershipId();
        Byte membershipType = playerApi.getResponse().get(0).getMembershipType();

        return charactersApiAddress
                .replace("{membershipType}", membershipType.toString())
                .replace("{membershipId}", membershipId);
    }
}
