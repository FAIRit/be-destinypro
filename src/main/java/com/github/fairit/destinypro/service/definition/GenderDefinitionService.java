package com.github.fairit.destinypro.service.definition;

import com.github.fairit.destinypro.entity.GenderEntity;
import com.github.fairit.destinypro.entity.api.charactergender.GenderSpecificApi;
import com.github.fairit.destinypro.repository.GenderRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class GenderDefinitionService {

    private final GenderDefinitionApiService genderApiService;
    private final GenderRepository genderRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public GenderDefinitionService(final GenderDefinitionApiService genderApiService, final GenderRepository genderRepository,
                                   final ModelMapper modelMapper) {
        this.genderApiService = genderApiService;
        this.genderRepository = genderRepository;
        this.modelMapper = modelMapper;
    }

    @Transactional
    public void saveGenderDefinitionInDB() {
        List<GenderEntity> genderEntityList = new ArrayList<>();

        for (final GenderSpecificApi genderSpecificApi : genderApiService.getListOfGenderDefinition()) {
            GenderEntity entity = modelMapper.map(genderSpecificApi, GenderEntity.class);
            genderEntityList.add(entity);
        }
        genderRepository.saveAll(genderEntityList);
    }
}
