package com.github.fairit.destinypro.service.characterservice;

import com.github.fairit.destinypro.config.ApplicationConfig;
import com.github.fairit.destinypro.dto.character.api.AllCharactersApiData;
import com.github.fairit.destinypro.dto.character.api.AllCharactersApiResponse;
import com.github.fairit.destinypro.dto.playerapi.PlayerApi;
import com.github.fairit.destinypro.exception.ApiNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class CharacterApiService {

    private final RestTemplate restTemplate;
    private final ApplicationConfig httpConfig;

    @Value("${api.bungie.address.listofcharacters}")
    private String charactersApiAddress;

    @Autowired
    public CharacterApiService(final RestTemplate restTemplate, final ApplicationConfig httpConfig) {
        this.restTemplate = restTemplate;
        this.httpConfig = httpConfig;
    }

    public List<AllCharactersApiData> getListOfPlayerCharactersFromApi(final PlayerApi playerApi) {
        List<AllCharactersApiData> allCharactersApiDataList = new ArrayList<>();
        for (Map.Entry<Object, AllCharactersApiData> dataEntry : getCharactersApiResponseMap(playerApi).entrySet()) {
            allCharactersApiDataList.add(dataEntry.getValue());
        }
        return allCharactersApiDataList;
    }

    private Map<Object, AllCharactersApiData> getCharactersApiResponseMap(final PlayerApi playerApi) {

        String addressURL = getCorrectCharacterApiAddress(playerApi);
        AllCharactersApiResponse characterApi = restTemplate
                .exchange(addressURL, HttpMethod.GET, httpConfig.getHttpEntity(), AllCharactersApiResponse.class, 1)
                .getBody();

        if (characterApi != null) {
            return characterApi.getResponse().getCharacter().getCharacterData();
        }
        throw new ApiNotFoundException(AllCharactersApiData.class);
    }

    private String getCorrectCharacterApiAddress(final PlayerApi playerApi) {
        String membershipId = playerApi.getResponse().get(0).getMembershipId();
        Byte membershipType = playerApi.getResponse().get(0).getMembershipType();

        return charactersApiAddress
                .replace("{membershipType}", membershipType.toString())
                .replace("{membershipId}", membershipId);
    }
}
