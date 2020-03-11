package com.github.fairit.destinypro.service.definitions_service;

import com.github.fairit.destinypro.entity.ClassEntity;
import com.github.fairit.destinypro.entity.api.api_class.ClassSpecificApi;
import com.github.fairit.destinypro.repository.ClassRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class ClassDefinitionService {

    private ClassDefinitionApiService classApiService;
    private ClassRepository classRepository;

    @Autowired
    public ClassDefinitionService(final ClassDefinitionApiService classApiService, final ClassRepository classRepository) {
        this.classApiService = classApiService;
        this.classRepository = classRepository;
    }

    @Transactional
    public void saveClassDefinitionInDB() {
        ModelMapper modelMapper = new ModelMapper();
        List<ClassEntity> classEntityList = new ArrayList<>();

        for (final ClassSpecificApi classSpecificApi : classApiService.getListOfClassDefinition()) {
            ClassEntity entity = modelMapper.map(classSpecificApi, ClassEntity.class);
            classEntityList.add(entity);
        }
        classRepository.saveAll(classEntityList);
    }
}
