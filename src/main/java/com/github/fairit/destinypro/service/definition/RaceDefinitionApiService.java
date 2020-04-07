package com.github.fairit.destinypro.service.definition;

import com.github.fairit.destinypro.entity.api.characterrace.RaceApi;
import com.github.fairit.destinypro.entity.api.characterrace.RaceSpecificApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class RaceDefinitionApiService {

    private final RestTemplate restTemplate;
    private final DefinitionsUrlApiService definitionsUrlApiService;

    @Autowired
    public RaceDefinitionApiService(final RestTemplate restTemplate, final DefinitionsUrlApiService definitionsUrlApiService) {
        this.restTemplate = restTemplate;
        this.definitionsUrlApiService = definitionsUrlApiService;
    }

    public List<RaceSpecificApi> getListOfRaceDefinition() {
        RaceApi raceApiObject = restTemplate
                .getForObject(definitionsUrlApiService.getRaceApiAddress(), RaceApi.class);

        List<RaceSpecificApi> listOfRaceDefinition = new ArrayList<>();
        if (raceApiObject != null) {
            listOfRaceDefinition.add(raceApiObject.getAwoken());
            listOfRaceDefinition.add(raceApiObject.getExo());
            listOfRaceDefinition.add(raceApiObject.getHuman());
        }
        return listOfRaceDefinition;
    }
}
