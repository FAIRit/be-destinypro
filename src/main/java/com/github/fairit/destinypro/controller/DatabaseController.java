package com.github.fairit.destinypro.controller;

import com.github.fairit.destinypro.service.definition.ClassDefinitionService;
import com.github.fairit.destinypro.service.definition.GenderDefinitionService;
import com.github.fairit.destinypro.service.definition.RaceDefinitionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DatabaseController {

    private final ClassDefinitionService classService;
    private final GenderDefinitionService genderService;
    private final RaceDefinitionService raceService;

    @Autowired
    public DatabaseController(final ClassDefinitionService classService, final GenderDefinitionService genderService,
                              final RaceDefinitionService raceService) {
        this.classService = classService;
        this.genderService = genderService;
        this.raceService = raceService;
    }

    @EventListener(ApplicationReadyEvent.class)
    public void saveDefinitionsInDB() {
        classService.saveClassDefinitionInDB();
        genderService.saveGenderDefinitionInDB();
        raceService.saveRaceDefinitionInDB();
    }
}
