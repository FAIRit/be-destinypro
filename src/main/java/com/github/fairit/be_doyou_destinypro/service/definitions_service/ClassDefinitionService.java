package com.github.fairit.be_doyou_destinypro.service.definitions_service;

import com.github.fairit.be_doyou_destinypro.entity.ClassEntity;
import com.github.fairit.be_doyou_destinypro.entity.DisplayPropertiesEntity;
import com.github.fairit.be_doyou_destinypro.entity.api.api_class.ClassSpecificApi;
import com.github.fairit.be_doyou_destinypro.repository.ClassRepository;
import com.github.fairit.be_doyou_destinypro.repository.DisplayPropertiesRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

@Service
public class ClassDefinitionService {

    private ClassDefinitionApiService classApiService;
    private ClassRepository classRepository;
    private DisplayPropertiesRepository propertiesRepository;

    @Autowired
    public ClassDefinitionService(final ClassDefinitionApiService classApiService, final ClassRepository classRepository, final DisplayPropertiesRepository propertiesRepository) {
        this.classApiService = classApiService;
        this.classRepository = classRepository;
        this.propertiesRepository = propertiesRepository;
    }

    @Transactional
    public void saveClassDefinitionInDB() {
        ModelMapper modelMapper = new ModelMapper();
        List<ClassEntity> classEntityList = new ArrayList<>();
        List<DisplayPropertiesEntity> propertiesEntityList = new ArrayList<>();

        for (final ClassSpecificApi classSpecificApi : classApiService.getListOfClassDefinition()) {
            ClassEntity entity = modelMapper.map(classSpecificApi, ClassEntity.class);
            DisplayPropertiesEntity propertiesEntity = modelMapper.map(classSpecificApi.getDisplayProperties(), DisplayPropertiesEntity.class);
            classEntityList.add(entity);
            propertiesEntityList.add(propertiesEntity);
        }
        propertiesRepository.saveAll(propertiesEntityList);
        classRepository.saveAll(classEntityList);
    }
}
