package com.github.fairit.be_doyou_destinypro.service.definitions_service;

import com.github.fairit.be_doyou_destinypro.entity.DisplayPropertiesEntity;
import com.github.fairit.be_doyou_destinypro.entity.RaceEntity;
import com.github.fairit.be_doyou_destinypro.entity.api.api_race.RaceSpecificApi;
import com.github.fairit.be_doyou_destinypro.repository.DisplayPropertiesRepository;
import com.github.fairit.be_doyou_destinypro.repository.RaceRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

@Service
public class RaceDefinitionService {

    private RaceDefinitionApiService raceApiService;
    private RaceRepository raceRepository;
    private DisplayPropertiesRepository propertiesRepository;

    @Autowired
    public RaceDefinitionService(final RaceDefinitionApiService raceApiService, final RaceRepository raceRepository, final DisplayPropertiesRepository propertiesRepository) {
        this.raceApiService = raceApiService;
        this.raceRepository = raceRepository;
        this.propertiesRepository = propertiesRepository;
    }

    @Transactional
    public void saveRaceDefinitionInDB() {
        ModelMapper modelMapper = new ModelMapper();
        List<RaceEntity> raceEntityList = new ArrayList<>();
        List<DisplayPropertiesEntity> propertiesEntityList = new ArrayList<>();

        for (final RaceSpecificApi raceSpecificApi : raceApiService.getListOfRaceDefinition()) {
            RaceEntity entity = modelMapper.map(raceSpecificApi, RaceEntity.class);
            DisplayPropertiesEntity propertiesEntity = modelMapper.map(raceSpecificApi.getDisplayProperties(), DisplayPropertiesEntity.class);
            raceEntityList.add(entity);
            propertiesEntityList.add(propertiesEntity);
        }
        propertiesRepository.saveAll(propertiesEntityList);
        raceRepository.saveAll(raceEntityList);
    }
}
