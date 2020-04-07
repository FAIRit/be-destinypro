package com.github.fairit.destinypro;

import com.github.fairit.destinypro.controller.PlayerControllerTest;
import com.github.fairit.destinypro.serviceimpl.character.CharacterApiServiceTest;
import com.github.fairit.destinypro.serviceimpl.player.PlayerApiServiceTest;
import com.github.fairit.destinypro.serviceimpl.player.PlayerServiceTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({PlayerControllerTest.class, CharacterApiServiceTest.class, PlayerApiServiceTest.class,
        PlayerServiceTest.class})
public class BeDoyouDestinyproApplicationTests {
}
