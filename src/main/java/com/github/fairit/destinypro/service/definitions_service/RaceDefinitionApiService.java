package com.github.fairit.destinypro.service.definitions_service;

import com.github.fairit.destinypro.entity.api.api_race.RaceApi;
import com.github.fairit.destinypro.entity.api.api_race.RaceSpecificApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class RaceDefinitionApiService {

    private RestTemplate restTemplate;

    @Autowired
    public RaceDefinitionApiService(final RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<RaceSpecificApi> getListOfRaceDefinition() {
        String raceDefinitionApiAddress
                = "https://www.bungie.net/common/destiny2_content/json/en/DestinyRaceDefinition-39a4e3a0-efbe-4356-beca-d87271a5c699.json";
        RaceApi raceApiObject = restTemplate.getForObject(raceDefinitionApiAddress, RaceApi.class);

        List<RaceSpecificApi> listOfRaceDefinition = new ArrayList<>();
        if (raceApiObject != null) {
            listOfRaceDefinition.add(raceApiObject.getAwoken());
            listOfRaceDefinition.add(raceApiObject.getExo());
            listOfRaceDefinition.add(raceApiObject.getHuman());
        }
        return listOfRaceDefinition;
    }
}
