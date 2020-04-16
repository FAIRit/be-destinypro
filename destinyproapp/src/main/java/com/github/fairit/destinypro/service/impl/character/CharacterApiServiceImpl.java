package com.github.fairit.destinypro.service.impl.character;

import com.github.fairit.destinypro.dto.character.api.AllCharactersApiData;
import com.github.fairit.destinypro.dto.character.api.AllCharactersApiResponse;
import com.github.fairit.destinypro.dto.player.api.PlayerApi;
import com.github.fairit.destinypro.exception.ApiNotFoundException;
import com.github.fairit.destinypro.exception.BadCharacterRequestException;
import com.github.fairit.destinypro.service.character.CharacterApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.toList;

@Service
public class CharacterApiServiceImpl implements CharacterApiService {

    private final RestTemplate restTemplate;
    private final HttpEntity<?> httpEntity;

    @Value("${api.bungie.address.listofcharacters}")
    protected String charactersApiAddress;

    @Autowired
    public CharacterApiServiceImpl(final RestTemplate restTemplate, final HttpEntity<?> httpEntity) {
        this.restTemplate = restTemplate;
        this.httpEntity = httpEntity;
    }

    @Override
    public List<AllCharactersApiData> getListOfPlayerCharactersFromApi(final PlayerApi playerApi) {
        return getCharactersApiResponseMap(playerApi).values().stream().collect(toList());
    }

    private Map<Object, AllCharactersApiData> getCharactersApiResponseMap(final PlayerApi playerApi) {
        var addressURL = getCorrectCharacterApiAddress(playerApi);
        var responseEntity = restTemplate
                .exchange(addressURL, HttpMethod.GET, httpEntity, AllCharactersApiResponse.class, 1);
        if (responseEntity.getStatusCodeValue() != 200) {
            throw new BadCharacterRequestException();
        } else if (responseEntity.getBody() == null) {
            throw new ApiNotFoundException(AllCharactersApiData.class);
        }
        return responseEntity.getBody().getResponse().getCharacter().getCharacterData();
    }

    private String getCorrectCharacterApiAddress(final PlayerApi playerApi) {
        var membershipId = playerApi.getResponse().get(0).getMembershipId();
        var membershipType = playerApi.getResponse().get(0).getMembershipType();

        return charactersApiAddress
                .replace("{membershipType}", membershipType.toString())
                .replace("{membershipId}", membershipId);
    }
}
