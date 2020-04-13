package com.github.fairit.destinypro.service.impl.character;

import com.github.fairit.destinypro.dto.character.CharacterData;
import com.github.fairit.destinypro.dto.player.api.PlayerApi;
import com.github.fairit.destinypro.service.character.CharacterService;
import com.github.fairit.destinypro.service.player.PlayerApiService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.both;
import static org.hamcrest.Matchers.everyItem;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.instanceOf;
import static org.hamcrest.Matchers.lessThanOrEqualTo;
import static org.hamcrest.Matchers.notNullValue;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class CharacterServiceTest {

    @Autowired
    private PlayerApiService playerApiService;

    @Autowired
    private CharacterService characterService;

    @Mock
    private PlayerApi playerApi;

    @Before
    public void setUp() {


    }

    @Test
    public void getListOfPlayerCharactersFromApi() {

        List<CharacterData> characterDataList = characterService
                .getPlayerCharacters(playerApiService.findPlayerApiByNickname("katojido")).getCharacterDataList();

        assertThat(characterDataList, notNullValue());
        assertThat(characterDataList, everyItem(instanceOf(CharacterData.class)));
        assertThat(characterDataList, hasSize(both(greaterThan(0)).and(lessThanOrEqualTo(3))));
    }

}