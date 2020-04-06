package com.github.fairit.destinypro;

import com.github.fairit.destinypro.controller.PlayerControllerTest;
import com.github.fairit.destinypro.service.characterservice.CharacterApiServiceTest;
import com.github.fairit.destinypro.service.playerservice.PlayerApiServiceTest;
import com.github.fairit.destinypro.service.playerservice.PlayerServiceTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({PlayerControllerTest.class, CharacterApiServiceTest.class, PlayerApiServiceTest.class,
        PlayerServiceTest.class})
public class BeDoyouDestinyproApplicationTests {
}
