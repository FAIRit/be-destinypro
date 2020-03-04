package com.github.fairit.be_doyou_destinypro.service;

import com.github.fairit.be_doyou_destinypro.entity.api_gender.GenderApi;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class GenderDefinitionApiService {

    private RestTemplate restTemplate;
    public static final String GENDER_DEFINITION_API_URL =
            "https://www.bungie.net/common/destiny2_content/json/en/DestinyGenderDefinition-2fbe1829-dfcd-44ec-84d3-bb04a3777dc1.json";


    public GenderDefinitionApiService(final RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public void getFemaleGenderDefinition() {

        GenderApi object = restTemplate.getForObject(GENDER_DEFINITION_API_URL, GenderApi.class);

        if (object != null) {
            System.out.println(object.getMale().getDisplayProperties().getName());
        }
    }
}
