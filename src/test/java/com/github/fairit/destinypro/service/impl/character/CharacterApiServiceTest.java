package com.github.fairit.destinypro.service.impl.character;

import com.github.fairit.destinypro.dto.character.api.AllCharactersApiData;
import com.github.fairit.destinypro.service.character.CharacterApiService;
import com.github.fairit.destinypro.service.player.PlayerApiService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.both;
import static org.hamcrest.Matchers.everyItem;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.instanceOf;
import static org.hamcrest.Matchers.lessThanOrEqualTo;
import static org.hamcrest.Matchers.notNullValue;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CharacterApiServiceTest {

    @Autowired
    private CharacterApiService characterApiService;

    @Autowired
    private PlayerApiService playerApiService;

    @Test
    public void checkListOfPlayerCharactersFromApiWhenPlayerHasOneCharacter() {
        var allCharactersApiData = characterApiService
                .getListOfPlayerCharactersFromApi(playerApiService.findPlayerApiByNickname("katojido"));

        assertThat(allCharactersApiData, notNullValue());
        assertThat(allCharactersApiData, everyItem(instanceOf(AllCharactersApiData.class)));
        assertThat(allCharactersApiData, hasSize(both(greaterThan(0)).and(lessThanOrEqualTo(3))));
    }

    @Test
    public void checkListOfPlayerCharactersFromApiWhenPlayerHasThreeCharacters() {
        var allCharactersApiData = characterApiService
                .getListOfPlayerCharactersFromApi(playerApiService.findPlayerApiByNickname("akamre"));

        assertThat(allCharactersApiData, notNullValue());
        assertThat(allCharactersApiData, everyItem(instanceOf(AllCharactersApiData.class)));
        assertThat(allCharactersApiData, hasSize(both(greaterThan(0)).and(lessThanOrEqualTo(3))));
    }
}