package com.github.fairit.destinypro.service.definitionsservice;

import com.github.fairit.destinypro.entity.api.apiclass.ClassApi;
import com.github.fairit.destinypro.entity.api.apiclass.ClassSpecificApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class ClassDefinitionApiService {

    private RestTemplate restTemplate;
    private DefinitionsUrlApiService definitionsUrlApiService;

    @Autowired
    public ClassDefinitionApiService(final RestTemplate restTemplate, DefinitionsUrlApiService definitionsUrlApiService) {
        this.restTemplate = restTemplate;
        this.definitionsUrlApiService = definitionsUrlApiService;
    }

    public List<ClassSpecificApi> getListOfClassDefinition() {
         ClassApi classApiObject = restTemplate
                 .getForObject(definitionsUrlApiService.getClassApiAddress(), ClassApi.class);

        List<ClassSpecificApi> listOfClassDefinition = new ArrayList<>();
        if (classApiObject != null) {
            listOfClassDefinition.add(classApiObject.getHunter());
            listOfClassDefinition.add(classApiObject.getTitan());
            listOfClassDefinition.add(classApiObject.getWarlock());
        }
        return listOfClassDefinition;
    }
}
