package com.github.fairit.destinypro.service.impl.definition;

import com.github.fairit.destinypro.entity.api.characterclass.ClassApi;
import com.github.fairit.destinypro.entity.api.characterclass.ClassSpecificApi;
import com.github.fairit.destinypro.service.definition.DefinitionApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class ClassDefinitionApiServiceImpl implements DefinitionApiService {

    private final RestTemplate restTemplate;
    private final DefinitionsUrlApiService definitionsUrlApiService;

    @Autowired
    public ClassDefinitionApiServiceImpl(final RestTemplate restTemplate, final DefinitionsUrlApiService definitionsUrlApiService) {
        this.restTemplate = restTemplate;
        this.definitionsUrlApiService = definitionsUrlApiService;
    }

    public List<ClassSpecificApi> getListOfDefinition() {
        var classApiObject = restTemplate
                .getForObject(definitionsUrlApiService.getClassApiAddress(), ClassApi.class);

        var listOfClassDefinition = new ArrayList<ClassSpecificApi>();
        if (classApiObject != null) {
            listOfClassDefinition.add(classApiObject.getHunter());
            listOfClassDefinition.add(classApiObject.getTitan());
            listOfClassDefinition.add(classApiObject.getWarlock());
        }
        return listOfClassDefinition;
    }
}
