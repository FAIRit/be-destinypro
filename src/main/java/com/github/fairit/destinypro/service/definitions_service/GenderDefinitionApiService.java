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

    @Autowired
    public GenderDefinitionApiService(final RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<GenderSpecificApi> getListOfGenderDefinition() {

        String genderDefinitionApiAddress
                = "https://www.bungie.net/common/destiny2_content/json/en/DestinyGenderDefinition-39a4e3a0-efbe-4356-beca-d87271a5c699.json";
        GenderApi genderApiObject = restTemplate.getForObject(genderDefinitionApiAddress, GenderApi.class);

        List<GenderSpecificApi> listOfGenderDefinition = new ArrayList<>();
        if (genderApiObject != null) {
            listOfGenderDefinition.add(genderApiObject.getFemale());
            listOfGenderDefinition.add(genderApiObject.getMale());
        }
        return listOfGenderDefinition;
    }
}
