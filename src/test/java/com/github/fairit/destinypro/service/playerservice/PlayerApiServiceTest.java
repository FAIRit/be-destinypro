package com.github.fairit.destinypro.service.playerservice;


import com.github.fairit.destinypro.dto.playerapi.PlayerApi;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PlayerApiServiceTest {

    @Autowired
    private PlayerApiService playerApiService;

    @Test
    public void findPlayerApiByNicknameByNicknameShouldReturnCorrectedPlayerJson() {

        PlayerApi playerByNickname = playerApiService.findPlayerApiByNickname("katojido");

        assertThat(playerByNickname, notNullValue());
        assertThat(playerByNickname.getResponse().get(0).getDisplayName(), containsString("katojido"));
        assertThat(playerByNickname.getResponse().get(0).getMembershipId(), containsString("4611686018485400803"));
        assertThat(playerByNickname.getResponse().get(0).getMembershipId(), containsString("3"));
        assertThat(playerByNickname, instanceOf(PlayerApi.class));
    }
}