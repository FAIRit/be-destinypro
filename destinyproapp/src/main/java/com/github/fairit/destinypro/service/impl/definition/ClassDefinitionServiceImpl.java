package com.github.fairit.destinypro.service.impl.definition;

import com.github.fairit.destinypro.entity.ClassEntity;
import com.github.fairit.destinypro.repository.ClassRepository;
import com.github.fairit.destinypro.service.definition.DefinitionService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class ClassDefinitionServiceImpl implements DefinitionService {

    private final ClassDefinitionApiServiceImpl classApiService;
    private final ClassRepository classRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public ClassDefinitionServiceImpl(final ClassDefinitionApiServiceImpl classApiService, final ClassRepository classRepository,
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
        var classEntityList = new ArrayList<ClassEntity>();

        for (final var classSpecificApi : classApiService.getListOfDefinition()) {
            var entity = modelMapper.map(classSpecificApi, ClassEntity.class);
            classEntityList.add(entity);
        }
        return classEntityList;
    }
}
