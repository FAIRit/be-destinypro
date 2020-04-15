package com.github.fairit.destinypro.controller;

import com.github.fairit.destinypro.service.impl.definition.ClassDefinitionServiceImpl;
import com.github.fairit.destinypro.service.impl.definition.GenderDefinitionServiceImpl;
import com.github.fairit.destinypro.service.impl.definition.RaceDefinitionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DatabaseController {

    private final ClassDefinitionServiceImpl classService;
    private final GenderDefinitionServiceImpl genderService;
    private final RaceDefinitionService raceService;

    @Autowired
    public DatabaseController(final ClassDefinitionServiceImpl classService, final GenderDefinitionServiceImpl genderService,
                              final RaceDefinitionService raceService) {
        this.classService = classService;
        this.genderService = genderService;
        this.raceService = raceService;
    }

    @EventListener(ApplicationReadyEvent.class)
    public void saveDefinitionsInDB() {
        classService.saveDefinitionInDB();
        genderService.saveDefinitionInDB();
        raceService.saveDefinitionInDB();
    }
}
