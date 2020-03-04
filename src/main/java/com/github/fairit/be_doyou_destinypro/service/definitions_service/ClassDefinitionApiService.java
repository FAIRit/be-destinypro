package com.github.fairit.be_doyou_destinypro.service.definitions_service;

import com.github.fairit.be_doyou_destinypro.entity.api.api_class.ClassApi;
import com.github.fairit.be_doyou_destinypro.entity.api.api_class.ClassSpecificApi;
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
                = "https://www.bungie.net/common/destiny2_content/json/en/DestinyClassDefinition-2fbe1829-dfcd-44ec-84d3-bb04a3777dc1.json";
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
