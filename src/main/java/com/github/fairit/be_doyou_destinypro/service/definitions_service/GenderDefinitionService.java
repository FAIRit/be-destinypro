package com.github.fairit.be_doyou_destinypro.service.definitions_service;

import com.github.fairit.be_doyou_destinypro.entity.DisplayPropertiesEntity;
import com.github.fairit.be_doyou_destinypro.entity.GenderEntity;
import com.github.fairit.be_doyou_destinypro.entity.api.api_gender.GenderSpecificApi;
import com.github.fairit.be_doyou_destinypro.repository.DisplayPropertiesRepository;
import com.github.fairit.be_doyou_destinypro.repository.GenderRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

@Service
public class GenderDefinitionService {

    private GenderDefinitionApiService genderApiService;
    private GenderRepository genderRepository;
    private DisplayPropertiesRepository propertiesRepository;

    @Autowired
    public GenderDefinitionService(final GenderDefinitionApiService genderApiService, final GenderRepository genderRepository, final DisplayPropertiesRepository propertiesRepository) {
        this.genderApiService = genderApiService;
        this.genderRepository = genderRepository;
        this.propertiesRepository = propertiesRepository;
    }

    @Transactional
    public void saveGenderDefinitionInDB() {
        ModelMapper modelMapper = new ModelMapper();
        List<GenderEntity> genderEntityList = new ArrayList<>();
        List<DisplayPropertiesEntity> propertiesEntityList = new ArrayList<>();

        for (final GenderSpecificApi genderSpecificApi : genderApiService.getListOfGenderDefinition()) {
            GenderEntity entity = modelMapper.map(genderSpecificApi, GenderEntity.class);
            DisplayPropertiesEntity propertiesEntity = modelMapper.map(genderSpecificApi.getDisplayProperties(), DisplayPropertiesEntity.class);
            genderEntityList.add(entity);
            propertiesEntityList.add(propertiesEntity);
        }
        propertiesRepository.saveAll(propertiesEntityList);
        genderRepository.saveAll(genderEntityList);
    }
}
