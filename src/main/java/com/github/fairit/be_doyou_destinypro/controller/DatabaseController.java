package com.github.fairit.be_doyou_destinypro.controller;

import com.github.fairit.be_doyou_destinypro.service.definitions_service.ClassDefinitionService;
import com.github.fairit.be_doyou_destinypro.service.definitions_service.GenderDefinitionService;
import com.github.fairit.be_doyou_destinypro.service.definitions_service.RaceDefinitionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DatabaseController {

    private ClassDefinitionService classService;
    private GenderDefinitionService genderService;
    private RaceDefinitionService raceService;

    @Autowired
    public DatabaseController(final ClassDefinitionService classService, final GenderDefinitionService genderService, final RaceDefinitionService raceService) {
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
