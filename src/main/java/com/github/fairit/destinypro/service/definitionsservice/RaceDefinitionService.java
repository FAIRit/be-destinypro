package com.github.fairit.destinypro.service.definitionsservice;

import com.github.fairit.destinypro.entity.RaceEntity;
import com.github.fairit.destinypro.entity.api.apirace.RaceSpecificApi;
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
    private ModelMapper modelMapper;

    @Autowired
    public RaceDefinitionService(final RaceDefinitionApiService raceApiService, final RaceRepository raceRepository, ModelMapper modelMapper) {
        this.raceApiService = raceApiService;
        this.raceRepository = raceRepository;
        this.modelMapper = modelMapper;
    }

    @Transactional
    public void saveRaceDefinitionInDB() {
        List<RaceEntity> raceEntityList = new ArrayList<>();

        for (final RaceSpecificApi raceSpecificApi : raceApiService.getListOfRaceDefinition()) {
            RaceEntity entity = modelMapper.map(raceSpecificApi, RaceEntity.class);
            raceEntityList.add(entity);
        }
        raceRepository.saveAll(raceEntityList);
    }
}
