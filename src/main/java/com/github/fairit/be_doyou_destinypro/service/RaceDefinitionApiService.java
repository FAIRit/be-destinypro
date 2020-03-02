package com.github.fairit.be_doyou_destinypro.service;

import com.github.fairit.be_doyou_destinypro.entity.api_race.RaceApi;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class RaceDefinitionApiService {

    private RestTemplate restTemplate;
    public static final String RACE_DEFINITION_API_URL =
            "https://www.bungie.net/common/destiny2_content/json/en/DestinyRaceDefinition-2fbe1829-dfcd-44ec-84d3-bb04a3777dc1.json";


    public RaceDefinitionApiService(final RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }


    public void getHumanRaceDefinitions() {

        RaceApi object = restTemplate.getForObject(RACE_DEFINITION_API_URL, RaceApi.class);

        if (object != null) {
            System.out.println(object.getExo().getRaceDisplayProperties().getDescription());
        }
    }
}
