package com.github.fairit.destinypro.service.character_service;

import com.github.fairit.destinypro.dto.character.api.AllCharactersApiData;
import com.github.fairit.destinypro.service.player_service.PlayerApiService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CharacterApiServiceTest {

    @Autowired
    private CharacterApiService characterApiService;

    @Autowired
    private PlayerApiService playerApiService;

    @Test
    public void checkListOfPlayerCharactersFromApiWhenPlayerHasOneCharacter() {
        List<AllCharactersApiData> allCharactersApiData = characterApiService
                .getListOfPlayerCharactersFromApi(playerApiService.findPlayerApiByNickname("katojido"));

        assertThat(allCharactersApiData, notNullValue());
        assertThat(allCharactersApiData, everyItem(instanceOf(AllCharactersApiData.class)));
        assertThat(allCharactersApiData, hasSize(both(greaterThan(0)).and(lessThanOrEqualTo(3))));
    }

    @Test
    public void checkListOfPlayerCharactersFromApiWhenPlayerHasThreeCharacters() {
        List<AllCharactersApiData> allCharactersApiData = characterApiService
                .getListOfPlayerCharactersFromApi(playerApiService.findPlayerApiByNickname("akamre"));

        assertThat(allCharactersApiData, notNullValue());
        assertThat(allCharactersApiData, everyItem(instanceOf(AllCharactersApiData.class)));
        assertThat(allCharactersApiData, hasSize(both(greaterThan(0)).and(lessThanOrEqualTo(3))));
    }
}