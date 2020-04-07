package com.github.fairit.destinypro.serviceimpl.definition;

import com.github.fairit.destinypro.entity.api.charactergender.GenderApi;
import com.github.fairit.destinypro.entity.api.charactergender.GenderSpecificApi;
import com.github.fairit.destinypro.service.definition.DefinitionApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class GenderDefinitionApiServiceImpl implements DefinitionApiService {

    private final RestTemplate restTemplate;
    private final DefinitionsUrlApiService definitionsUrlApiService;

    @Autowired
    public GenderDefinitionApiServiceImpl(final RestTemplate restTemplate, final DefinitionsUrlApiService definitionsUrlApiService) {
        this.restTemplate = restTemplate;
        this.definitionsUrlApiService = definitionsUrlApiService;
    }

    @Override
    public List<GenderSpecificApi> getListOfDefinition() {
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
