package com.github.fairit.destinypro.service.impl.player;

import com.github.fairit.destinypro.dto.player.api.PlayerApi;
import com.github.fairit.destinypro.service.player.PlayerService;
import com.google.gson.Gson;
import org.json.JSONException;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.instanceOf;
import static org.hamcrest.Matchers.notNullValue;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class PlayerServiceTest {

    private static final String PLAYER_KATOJIDO_JSON
            = "{\"response\":[{\"membershipType\":3,\"membershipId\":\"4611686018485400803\",\"displayName\":\"katojido\"}]}";

    @Autowired
    private PlayerService playerService;

    private PlayerApi playerApi;

    private String jsonString;

    @Before
    public void setUp() {
        playerApi = playerService.findPlayerByNickname("katojido");
        jsonString = new Gson().toJson(playerApi);
    }

    @Test
    public void findPlayerMethodShouldReturnInstanceOfPlayerApi() {
        assertThat(playerApi, notNullValue());
        assertThat(playerApi, instanceOf(PlayerApi.class));
    }

    @Test
    public void checkPlayerApiJsonShouldBeAsSchema() throws JSONException {
        JSONAssert.assertEquals(jsonString, PLAYER_KATOJIDO_JSON, true);
    }
}
