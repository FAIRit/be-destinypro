package com.github.fairit.destinypro.serviceimpl.definition;

import com.github.fairit.destinypro.entity.GenderEntity;
import com.github.fairit.destinypro.entity.api.charactergender.GenderSpecificApi;
import com.github.fairit.destinypro.repository.GenderRepository;
import com.github.fairit.destinypro.service.definition.DefinitionService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class GenderDefinitionServiceImpl implements DefinitionService {

    private final GenderDefinitionApiServiceImpl genderApiService;
    private final GenderRepository genderRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public GenderDefinitionServiceImpl(final GenderDefinitionApiServiceImpl genderApiService, final GenderRepository genderRepository,
                                       final ModelMapper modelMapper) {
        this.genderApiService = genderApiService;
        this.genderRepository = genderRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    @Transactional
    public void saveDefinitionInDB() {
        genderRepository.saveAll(getGenderEntities());
    }

    private List<GenderEntity> getGenderEntities() {
        List<GenderEntity> genderEntityList = new ArrayList<>();

        for (final GenderSpecificApi genderSpecificApi : genderApiService.getListOfDefinition()) {
            GenderEntity entity = modelMapper.map(genderSpecificApi, GenderEntity.class);
            genderEntityList.add(entity);
        }
        return genderEntityList;
    }
}
