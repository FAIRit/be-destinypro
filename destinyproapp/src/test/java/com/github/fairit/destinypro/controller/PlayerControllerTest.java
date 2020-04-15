package com.github.fairit.destinypro.controller;

import com.github.fairit.destinypro.dto.character.Characters;
import com.github.fairit.destinypro.dto.pvepvpstats.CharacterPve;
import com.github.fairit.destinypro.dto.pvepvpstats.CharacterPvp;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.instanceOf;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class PlayerControllerTest {

    public static final String NICKNAME = "katojido";
    public static final String CHARACTER_ID = "2305843009410040403";

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private PlayerController playerController;

    @Test
    public void shouldReturnExpectedContentTypeForSearchPlayerByNickname() throws Exception {
        mockMvc
                .perform(get("/findplayer/katojido"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));

        mockMvc
                .perform(get("/findplayer/katojid"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void shouldReturnCharactersClass() {
        var characters = playerController.searchPlayerByNicknameAndShowCharacters(NICKNAME);

        assertThat(characters, is(notNullValue()));
        assertThat(characters, is(instanceOf(Characters.class)));
    }

    @Test
    public void shouldReturnExpectedContentTypeForSearchCharacterPvPStats() throws Exception {
        mockMvc
                .perform(get("/findplayer/" + NICKNAME + "/pvpstats/" + CHARACTER_ID))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }

    @Test
    public void shouldReturnCharacterActivityStatsForSearchCharacterPvPStats() {
        var pvpStatsForCharacter = playerController
                .showPvpStatsForCharacter(NICKNAME, CHARACTER_ID);

        assertThat(pvpStatsForCharacter, is(notNullValue()));
        assertThat(pvpStatsForCharacter, is(instanceOf(CharacterPvp.class)));
    }

    @Test
    public void shouldReturnExpectedContentTypeForSearchCharacterPvEStats() throws Exception {
        mockMvc
                .perform(get("/findplayer/" + NICKNAME + "/pvestats/" + CHARACTER_ID))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }

    @Test
    public void shouldReturnCharacterActivityStatsForSearchCharacterPvEStats() {
        var pveStatsForCharacter = playerController
                .showPveStatsForCharacter(NICKNAME, CHARACTER_ID);

        assertThat(pveStatsForCharacter, is(notNullValue()));
        assertThat(pveStatsForCharacter, is(instanceOf(CharacterPve.class)));
    }
}
