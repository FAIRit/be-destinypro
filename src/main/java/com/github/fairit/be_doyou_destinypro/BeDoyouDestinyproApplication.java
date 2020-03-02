package com.github.fairit.be_doyou_destinypro;

import com.github.fairit.be_doyou_destinypro.service.ClassDefinitionApiService;
import com.github.fairit.be_doyou_destinypro.service.GenderDefinitionApiService;
import com.github.fairit.be_doyou_destinypro.service.RaceDefinitionApiService;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class BeDoyouDestinyproApplication {

    public static void main(String[] args) {
//        SpringApplication.run(BeDoyouDestinyproApplication.class, args);

        RaceDefinitionApiService raceDefinitionApiService = new RaceDefinitionApiService(new RestTemplate());
        ClassDefinitionApiService classDefinitionApiService = new ClassDefinitionApiService(new RestTemplate());
        GenderDefinitionApiService genderDefinitionApiService = new GenderDefinitionApiService(new RestTemplate());
        raceDefinitionApiService.getHumanRaceDefinitions();
//        classDefinitionApiService.getTitanClassDefinition();
//        genderDefinitionApiService.getFemaleGenderDefinition();
    }

    @Bean
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }
}
