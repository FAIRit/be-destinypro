package com.github.fairit.destinypro.service.impl.player;

import com.github.fairit.destinypro.dto.player.api.PlayerApi;
import com.github.fairit.destinypro.dto.player.api.Response;
import com.google.gson.Gson;
import org.json.JSONException;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.io.StringReader;
import java.util.ArrayList;
import java.util.Objects;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalToIgnoringCase;
import static org.hamcrest.Matchers.instanceOf;
import static org.hamcrest.Matchers.notNullValue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class PlayerApiServiceImplTest {

    private static final String PLAYER_JSON
            = "{\"response\":[{\"membershipType\":3,\"membershipId\":\"1234\",\"displayName\":\"nick\"}]}";

    private String nickname;
    private PlayerApi playerApi;

    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();

    @Mock
    private RestTemplate restTemplate;

    @Mock
    private HttpEntity<?> httpEntity;

    @Mock
    private ResponseEntity<PlayerApi> playerApiResponse;

    @InjectMocks
    private PlayerApiServiceImpl apiService;

    @Before
    public void setUp() {
        nickname = "name";
        apiService.playerApiAddress = "http://test/{nickname}".replace("{nickname}", nickname);
        when(restTemplate
                .exchange(anyString(), any(HttpMethod.class), eq(httpEntity), eq(PlayerApi.class), eq(1)))
                .thenReturn(playerApiResponse);
        var body = mock(PlayerApi.class);
        when(playerApiResponse.getBody()).thenReturn(body);
        var playerResponse = mock(Response.class);
        var responseList = new ArrayList<Response>();
        responseList.add(playerResponse);
        when(playerResponse.getMembershipType()).thenReturn((byte) 3);
        when(playerResponse.getDisplayName()).thenReturn("nick");
        when(playerResponse.getMembershipId()).thenReturn("1234");
        when(Objects.requireNonNull(playerApiResponse.getBody()).getResponse()).thenReturn(responseList);
        when(playerApiResponse.getStatusCodeValue()).thenReturn(200);
    }

    @Test
    public void checkPlayerByNicknameFromApiIsInstanceOfPlayerApi() {
        playerApi = apiService.findPlayerApiByNickname(nickname);

        assertThat(playerApi, notNullValue());
        assertThat(playerApi, instanceOf(PlayerApi.class));
    }

    @Test
    public void checkPlayerByNicknameFromApiHaveCorrectJson() throws JSONException {
        playerApi = apiService.findPlayerApiByNickname(nickname);

        Gson gson = new Gson();
        PlayerApi playerApiFromJson = gson.fromJson(new StringReader(PLAYER_JSON), PlayerApi.class);
        Response responseFormJson = playerApiFromJson.getResponse().get(0);
        Response responseFromPlayerApi = playerApi.getResponse().get(0);

        assertThat(responseFromPlayerApi.getMembershipId(), equalToIgnoringCase(responseFormJson.getMembershipId()));
        assertThat(responseFromPlayerApi.getDisplayName(), equalToIgnoringCase(responseFormJson.getDisplayName()));
        assertThat(responseFromPlayerApi.getMembershipType().toString(), equalToIgnoringCase(responseFormJson.getMembershipType().toString()));
    }
}
