package com.github.fairit.be_doyou_destinypro.service.definitions_service;

import com.github.fairit.be_doyou_destinypro.entity.api.api_gender.GenderApi;
import com.github.fairit.be_doyou_destinypro.entity.api.api_gender.GenderSpecificApi;
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
                = "https://www.bungie.net/common/destiny2_content/json/en/DestinyGenderDefinition-2fbe1829-dfcd-44ec-84d3-bb04a3777dc1.json";
        GenderApi genderApiObject = restTemplate.getForObject(genderDefinitionApiAddress, GenderApi.class);

        List<GenderSpecificApi> listOfGenderDefinition = new ArrayList<>();
        if (genderApiObject != null) {
            listOfGenderDefinition.add(genderApiObject.getFemale());
            listOfGenderDefinition.add(genderApiObject.getMale());
        }
        return listOfGenderDefinition;
    }
}
