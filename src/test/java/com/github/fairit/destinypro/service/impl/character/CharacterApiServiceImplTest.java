package com.github.fairit.destinypro.service.impl.character;

import com.github.fairit.destinypro.dto.character.api.AllCharactersApiData;
import com.github.fairit.destinypro.dto.character.api.AllCharactersApiResponse;
import com.github.fairit.destinypro.dto.player.api.PlayerApi;
import com.github.fairit.destinypro.dto.player.api.Response;
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

import java.util.ArrayList;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.both;
import static org.hamcrest.Matchers.everyItem;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.instanceOf;
import static org.hamcrest.Matchers.lessThanOrEqualTo;
import static org.hamcrest.Matchers.notNullValue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Matchers.anyString;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.when;

public class CharacterApiServiceImplTest {

    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();

    @Mock
    private RestTemplate restTemplate;

    @Mock
    private HttpEntity<?> httpEntity;

    @Mock
    private PlayerApi playerApi;

    @Mock
    private Response response;

    @Mock
    private ResponseEntity<AllCharactersApiResponse> allCharacterResponse;

    @InjectMocks
    private CharacterApiServiceImpl apiService;

    @Before
    public void setup() {
        apiService.charactersApiAddress = "http://test/{membershipType}/{membershipId}";
        var responseList = new ArrayList<Response>();
        when(playerApi.getResponse()).thenReturn(responseList);
        responseList.add(response);
        when(response.getMembershipId()).thenReturn("123");
        when(restTemplate.exchange(anyString(), any(HttpMethod.class), eq(httpEntity), eq(AllCharactersApiResponse.class), eq(1))).thenReturn(allCharacterResponse);
    }

    @Test
    public void checkListOfPlayerCharactersFromApiWhenPlayerHasOneCharacter() {
        var allCharactersApiData = apiService.getListOfPlayerCharactersFromApi(playerApi);

        assertThat(allCharactersApiData, notNullValue());
        assertThat(allCharactersApiData, everyItem(instanceOf(AllCharactersApiData.class)));
        assertThat(allCharactersApiData, hasSize(both(greaterThan(0)).and(lessThanOrEqualTo(3))));
    }
}
