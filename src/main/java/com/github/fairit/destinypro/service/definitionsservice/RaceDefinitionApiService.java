package com.github.fairit.destinypro.service.definitionsservice;

import com.github.fairit.destinypro.entity.api.apirace.RaceApi;
import com.github.fairit.destinypro.entity.api.apirace.RaceSpecificApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class RaceDefinitionApiService {

    private RestTemplate restTemplate;
    private DefinitionsUrlApiService definitionsUrlApiService;

    @Autowired
    public RaceDefinitionApiService(final RestTemplate restTemplate, DefinitionsUrlApiService definitionsUrlApiService) {
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
