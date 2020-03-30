package com.github.fairit.destinypro.service.definitions_service;

import com.github.fairit.destinypro.entity.api.api_gender.GenderApi;
import com.github.fairit.destinypro.entity.api.api_gender.GenderSpecificApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class GenderDefinitionApiService {

    private RestTemplate restTemplate;
    private DefinitionsUrlApiService definitionsUrlApiService;

    @Autowired
    public GenderDefinitionApiService(final RestTemplate restTemplate, DefinitionsUrlApiService definitionsUrlApiService) {
        this.restTemplate = restTemplate;
        this.definitionsUrlApiService = definitionsUrlApiService;
    }

    public List<GenderSpecificApi> getListOfGenderDefinition() {
         GenderApi genderApiObject = restTemplate
                 .getForObject(definitionsUrlApiService.getGenderApiAddress(), GenderApi.class);

        List<GenderSpecificApi> listOfGenderDefinition = new ArrayList<>();
        if (genderApiObject != null) {
            listOfGenderDefinition.add(genderApiObject.getFemale());
            listOfGenderDefinition.add(genderApiObject.getMale());
        }
        return listOfGenderDefinition;
    }
}
