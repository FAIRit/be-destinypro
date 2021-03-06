package com.github.fairit.destinypro.service.impl.player;


import com.github.fairit.destinypro.dto.player.api.PlayerApi;
import com.github.fairit.destinypro.service.player.PlayerApiService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.instanceOf;
import static org.hamcrest.Matchers.notNullValue;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PlayerApiServiceTest {

    @Autowired
    private PlayerApiService playerApiService;

    @Test
    public void findPlayerApiByNicknameShouldReturnCorrectedPlayerJson() {

        var playerByNickname = playerApiService.findPlayerApiByNickname("katojido");

        assertThat(playerByNickname, notNullValue());
        assertThat(playerByNickname.getResponse().get(0).getDisplayName(), containsString("katojido"));
        assertThat(playerByNickname.getResponse().get(0).getMembershipId(), containsString("4611686018485400803"));
        assertThat(playerByNickname.getResponse().get(0).getMembershipId(), containsString("3"));
        assertThat(playerByNickname, instanceOf(PlayerApi.class));
    }
}