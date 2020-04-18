package com.github.fairit.destinypro.service.impl.definition;

import com.github.fairit.destinypro.entity.api.charactergender.GenderApi;
import com.github.fairit.destinypro.entity.api.charactergender.GenderSpecificApi;
import com.github.fairit.destinypro.service.definition.DefinitionApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class GenderDefinitionApiServiceImpl implements DefinitionApiService<GenderSpecificApi> {

    private final RestTemplate restTemplate;
    private final DefinitionsUrlApiService definitionsUrlApiService;

    @Autowired
    public GenderDefinitionApiServiceImpl(final RestTemplate restTemplate, final DefinitionsUrlApiService definitionsUrlApiService) {
        this.restTemplate = restTemplate;
        this.definitionsUrlApiService = definitionsUrlApiService;
    }

    @Override
    public List<GenderSpecificApi> getListOfDefinition() {
        var genderApiObject = restTemplate
                .getForObject(definitionsUrlApiService.getGenderApiAddress(), GenderApi.class);

        var listOfGenderDefinition = new ArrayList<GenderSpecificApi>();
        if (genderApiObject != null) {
            listOfGenderDefinition.add(genderApiObject.getFemale());
            listOfGenderDefinition.add(genderApiObject.getMale());
        }
        return listOfGenderDefinition;
    }
}
