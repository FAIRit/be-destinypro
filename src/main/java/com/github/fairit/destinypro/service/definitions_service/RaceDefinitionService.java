package com.github.fairit.destinypro.service.definitions_service;

import com.github.fairit.destinypro.entity.RaceEntity;
import com.github.fairit.destinypro.entity.api.api_race.RaceSpecificApi;
import com.github.fairit.destinypro.repository.RaceRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class RaceDefinitionService {

    private RaceDefinitionApiService raceApiService;
    private RaceRepository raceRepository;

    @Autowired
    public RaceDefinitionService(final RaceDefinitionApiService raceApiService, final RaceRepository raceRepository) {
        this.raceApiService = raceApiService;
        this.raceRepository = raceRepository;
    }

    @Transactional
    public void saveRaceDefinitionInDB() {
        ModelMapper modelMapper = new ModelMapper();
        List<RaceEntity> raceEntityList = new ArrayList<>();

        for (final RaceSpecificApi raceSpecificApi : raceApiService.getListOfRaceDefinition()) {
            RaceEntity entity = modelMapper.map(raceSpecificApi, RaceEntity.class);
            raceEntityList.add(entity);
        }
        raceRepository.saveAll(raceEntityList);
    }
}
