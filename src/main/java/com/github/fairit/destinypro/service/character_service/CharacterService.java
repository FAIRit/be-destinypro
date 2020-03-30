package com.github.fairit.destinypro.service.character_service;

import com.github.fairit.destinypro.dto.character.CharacterData;
import com.github.fairit.destinypro.dto.character.CharacterGeneralStats;
import com.github.fairit.destinypro.dto.character.Characters;
import com.github.fairit.destinypro.dto.character.api.AllCharactersApiData;
import com.github.fairit.destinypro.dto.player.api.PlayerApi;
import com.github.fairit.destinypro.repository.ClassRepository;
import com.github.fairit.destinypro.repository.GenderRepository;
import com.github.fairit.destinypro.repository.RaceRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CharacterService {

    private CharacterApiService characterApiService;
    private ClassRepository classRepository;
    private GenderRepository genderRepository;
    private RaceRepository raceRepository;
    private ModelMapper modelMapper;

    @Autowired
    public CharacterService(CharacterApiService characterApiService, ClassRepository classRepository,
                            GenderRepository genderRepository, RaceRepository raceRepository, ModelMapper modelMapper) {
        this.characterApiService = characterApiService;
        this.classRepository = classRepository;
        this.genderRepository = genderRepository;
        this.raceRepository = raceRepository;
        this.modelMapper = modelMapper;
    }

    public Characters getListOfPlayerCharacters(PlayerApi playerApi) {

        List<AllCharactersApiData> listOfPlayerCharactersFromApi = characterApiService.getListOfPlayerCharactersFromApi(playerApi);
        List<CharacterData> characterDataList = new ArrayList<>();

        for (AllCharactersApiData characterApiData : listOfPlayerCharactersFromApi) {
            CharacterData characterData = modelMapper.map(characterApiData, CharacterData.class);
            CharacterGeneralStats characterGeneralStats = modelMapper.map(characterApiData.getCharacterStats(), CharacterGeneralStats.class);
            characterData.setCharacterGeneralStats(characterGeneralStats);
            characterData.setClassName(classRepository.findClassEntityByHash(characterApiData.getClassHash()).getProperties().getName());
            characterData.setGenderName(genderRepository.findByHash(characterApiData.getGenderHash()).getProperties().getName());
            characterData.setRaceName(raceRepository.findByHash(characterApiData.getRaceHash()).getProperties().getName());
            characterDataList.add(characterData);
        }
        return new Characters(characterDataList);
    }
}
