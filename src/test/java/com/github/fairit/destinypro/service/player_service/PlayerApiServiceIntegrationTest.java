package com.github.fairit.destinypro.service.player_service;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.fairit.destinypro.config.HttpConfig;
import com.github.fairit.destinypro.dto.player.api.PlayerApi;
import com.github.fairit.destinypro.dto.player.api.Response;
import com.github.tomakehurst.wiremock.core.WireMockConfiguration;
import com.github.tomakehurst.wiremock.junit.WireMockRule;
import com.github.tomakehurst.wiremock.matching.AnythingPattern;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.http.HttpHeaders;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.client.WireMock.get;
import static com.github.tomakehurst.wiremock.client.WireMock.urlEqualTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.instanceOf;
import static org.hamcrest.Matchers.notNullValue;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = PlayerApiServiceIntegrationTest.MockConfiguration.class)
@TestPropertySource(locations = "/application.properties", properties = {"api.bungie.address=http://localhost:9000/"})
public class PlayerApiServiceIntegrationTest {
    public static final String DISPLAY_NAME = "katojido";
    public static final String NOT_EXISTING_DISPLAY_NAME = "katojido2";
    public static final String MEMBERSHIP_ID = "4611686018485400803";

    @Configuration
    @Import(PlayerApiService.class)
    protected static class MockConfiguration {
        @Bean
        public RestTemplate getRestTemplate() {
            return new RestTemplate();
        }

        @Bean
        public HttpHeaders getHttpHeaders() {
            return new HttpHeaders();
        }

        @Bean
        public HttpConfig getHttpConfig() {
            return new HttpConfig(getHttpHeaders());
        }
    }

    @Rule
    public WireMockRule wireMockRule = new WireMockRule(WireMockConfiguration.options().port(9000));

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Autowired
    private PlayerApiService playerApiService;

    @Value("${api.bungie.address.player}")
    private String address;

    @Test
    @Ignore("Learning Test")
    public void validateTestProperties() {
        assertThat(address, equalTo("http://localhost:9000/SearchDestinyPlayer/-1/{nickname}/"));
    }

    @Test
    public void whenUserExistsThenPlayerIsReturned() throws InterruptedException {
        Response response = new Response();
        response.setDisplayName(DISPLAY_NAME);
        response.setMembershipId(MEMBERSHIP_ID);

        PlayerApi playerApi = new PlayerApi();
        playerApi.setResponse(Arrays.asList(response));

        wireMockRule.stubFor(
                get(urlEqualTo("/SearchDestinyPlayer/-1/" + DISPLAY_NAME + "/"))
                        .withHeader("x-api-key", new AnythingPattern())
                        .willReturn(aResponse()
                                .withHeader("Content-Type", "application/json")
                                .withJsonBody(new ObjectMapper().valueToTree(playerApi))
                        )
        );

        PlayerApi playerByNickname = playerApiService.findPlayerApiByNickname(DISPLAY_NAME);

        assertThat(playerByNickname, notNullValue());
        assertThat(playerByNickname.getResponse().get(0).getDisplayName(), containsString(DISPLAY_NAME));
        assertThat(playerByNickname.getResponse().get(0).getMembershipId(), containsString(MEMBERSHIP_ID));
        assertThat(playerByNickname, instanceOf(PlayerApi.class));
    }

    @Test
    public void whenUserDoesNotExistThenHttpClientErrorIsThrown() throws InterruptedException {
        wireMockRule.stubFor(
                get(urlEqualTo("/SearchDestinyPlayer/-1/" + NOT_EXISTING_DISPLAY_NAME + "/"))
                        .withHeader("x-api-key", new AnythingPattern())
                        .willReturn(aResponse()
                                .withStatus(404)
                        )
        );

        expectedException.expect(HttpClientErrorException.class);
        expectedException.expectMessage(containsString("404 Not Found"));
        PlayerApi playerByNickname = playerApiService.findPlayerApiByNickname(NOT_EXISTING_DISPLAY_NAME);
    }
}
