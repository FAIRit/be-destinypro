package com.github.fairit.destinypro.service.definitions_service;

import com.github.fairit.destinypro.entity.api.api_class.ClassApi;
import com.github.fairit.destinypro.entity.api.api_class.ClassSpecificApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class ClassDefinitionApiService {

    private RestTemplate restTemplate;

    @Autowired
    public ClassDefinitionApiService(final RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<ClassSpecificApi> getListOfClassDefinition() {
        String classDefinitionApiAddress
                = "https://www.bungie.net/common/destiny2_content/json/en/DestinyClassDefinition-39a4e3a0-efbe-4356-beca-d87271a5c699.json";
        ClassApi classApiObject = restTemplate.getForObject(classDefinitionApiAddress, ClassApi.class);

        List<ClassSpecificApi> listOfClassDefinition = new ArrayList<>();
        if (classApiObject != null) {
            listOfClassDefinition.add(classApiObject.getHunter());
            listOfClassDefinition.add(classApiObject.getTitan());
            listOfClassDefinition.add(classApiObject.getWarlock());
        }
        return listOfClassDefinition;
    }
}
