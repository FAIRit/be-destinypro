package com.github.fairit.destinypro.service.character_service;

import com.github.fairit.destinypro.dto.character.Character;
import com.github.fairit.destinypro.dto.character.CharacterData;
import com.github.fairit.destinypro.dto.characters.api.AllCharactersApiData;
import com.github.fairit.destinypro.dto.player.api.PlayerApi;
import com.github.fairit.destinypro.repository.ClassRepository;
import com.github.fairit.destinypro.repository.GenderRepository;
import com.github.fairit.destinypro.repository.RaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class CharacterService {

    private CharacterApiService characterApiService;
    private ClassRepository classRepository;
    private GenderRepository genderRepository;
    private RaceRepository raceRepository;

    @Autowired
    public CharacterService(final CharacterApiService characterApiService, final ClassRepository classRepository, final GenderRepository genderRepository, final RaceRepository raceRepository) {
        this.characterApiService = characterApiService;
        this.classRepository = classRepository;
        this.genderRepository = genderRepository;
        this.raceRepository = raceRepository;
    }

    public Map<Character, CharacterData> mapToListOfCharacters (PlayerApi playerApi) {
        Map<Object, AllCharactersApiData> dataMap = characterApiService.showListOfPlayerCharacters(playerApi);

        Map<Character, CharacterData> newMap = new HashMap<>();

        for (final Map.Entry<Object, AllCharactersApiData> dataEntry : dataMap.entrySet()) {
            CharacterData characterData = new CharacterData();
            characterData.setCharacterId(dataEntry.getValue().getCharacterId());
            characterData.setMembershipId(dataEntry.getValue().getMembershipId());
            characterData.setClassName(classRepository.findClassEntityByHash(dataEntry.getValue().getClassHash()).getProperties().getName());
            characterData.setGenderName(genderRepository.findByHash(dataEntry.getValue().getGenderHash()).getProperties().getName());
            characterData.setRaceName(raceRepository.findByHash(dataEntry.getValue().getRaceHash()).getProperties().getName());

            newMap.put(new Character(), characterData);
        }
         return newMap;

    }
}
