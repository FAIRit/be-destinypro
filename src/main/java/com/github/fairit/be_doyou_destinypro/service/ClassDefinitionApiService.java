package com.github.fairit.be_doyou_destinypro.service;

import com.github.fairit.be_doyou_destinypro.entity.api_class.ClassApi;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ClassDefinitionApiService {

    private RestTemplate restTemplate;
    public static final String CLASS_DEFINITION_API_URL =
            "https://www.bungie.net/common/destiny2_content/json/en/DestinyClassDefinition-2fbe1829-dfcd-44ec-84d3-bb04a3777dc1.json";


    public ClassDefinitionApiService(final RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }


    public void getTitanClassDefinition() {

        ClassApi object = restTemplate.getForObject(CLASS_DEFINITION_API_URL, ClassApi.class);

        if (object != null) {
            System.out.println(object.getHunter().getDisplayProperties().getName());
        }
    }
}
