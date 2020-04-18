package com.github.fairit.destinypro.service.impl.definition;

import com.github.fairit.destinypro.entity.ClassEntity;
import com.github.fairit.destinypro.entity.GenderEntity;
import com.github.fairit.destinypro.repository.ClassRepository;
import com.github.fairit.destinypro.service.definition.DefinitionService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClassDefinitionService implements DefinitionService {

    private final ClassDefinitionApiService classApiService;
    private final ClassRepository classRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public ClassDefinitionService(final ClassDefinitionApiService classApiService, final ClassRepository classRepository,
                                  final ModelMapper modelMapper) {
        this.classApiService = classApiService;
        this.classRepository = classRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    @Transactional
    public void saveDefinitionInDB() {
        classRepository.saveAll(getClassEntities());
    }

    private List<ClassEntity> getClassEntities() {
        return classApiService.getListOfDefinition()
                .stream()
                .map(def -> modelMapper.map(def, ClassEntity.class))
                .collect(Collectors.toList());
    }
}
