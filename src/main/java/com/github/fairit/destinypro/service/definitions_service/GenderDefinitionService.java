package com.github.fairit.destinypro.service.definitions_service;

import com.github.fairit.destinypro.entity.GenderEntity;
import com.github.fairit.destinypro.entity.api.api_gender.GenderSpecificApi;
import com.github.fairit.destinypro.repository.GenderRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class GenderDefinitionService {

    private GenderDefinitionApiService genderApiService;
    private GenderRepository genderRepository;

    @Autowired
    public GenderDefinitionService(final GenderDefinitionApiService genderApiService, final GenderRepository genderRepository) {
        this.genderApiService = genderApiService;
        this.genderRepository = genderRepository;
    }

    @Transactional
    public void saveGenderDefinitionInDB() {
        ModelMapper modelMapper = new ModelMapper();
        List<GenderEntity> genderEntityList = new ArrayList<>();

        for (final GenderSpecificApi genderSpecificApi : genderApiService.getListOfGenderDefinition()) {
            GenderEntity entity = modelMapper.map(genderSpecificApi, GenderEntity.class);
            genderEntityList.add(entity);
        }
        genderRepository.saveAll(genderEntityList);
    }
}
