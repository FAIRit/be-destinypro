package com.github.fairit.destinypro;

import com.github.fairit.destinypro.controller.PlayerControllerTest;
import com.github.fairit.destinypro.service.impl.character.CharacterApiServiceTest;
import com.github.fairit.destinypro.service.impl.player.PlayerApiServiceTest;
import com.github.fairit.destinypro.service.impl.player.PlayerServiceTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({PlayerControllerTest.class, CharacterApiServiceTest.class, PlayerApiServiceTest.class,
        PlayerServiceTest.class})
public class ApplicationTests {
}
