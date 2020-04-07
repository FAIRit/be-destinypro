package com.github.fairit.destinypro.service.stats;

import com.github.fairit.destinypro.config.ApplicationConfig;
import com.github.fairit.destinypro.dto.character.CharacterData;
import com.github.fairit.destinypro.dto.pvepvpstats.api.ActivityStatsApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class StatisticApiService {

    private final RestTemplate restTemplate;
    private final ApplicationConfig httpConfig;

    @Value("${api.bungie.address.playercharacterPVPstats}")
    private String pvpApiAddress;

    @Value("${api.bungie.address.playercharacterPVEstats}")
    private String pveApiAddress;

    @Autowired
    public StatisticApiService(final RestTemplate restTemplate, final ApplicationConfig httpConfig) {
        this.restTemplate = restTemplate;
        this.httpConfig = httpConfig;
    }

    public ActivityStatsApi getPvpStatsForGivenCharacter(final CharacterData character) {
        return restTemplate
                .exchange(getCorrectedApiAddressWithReplacements(pvpApiAddress, character),
                        HttpMethod.GET, httpConfig.getHttpEntity(), ActivityStatsApi.class, 1)
                .getBody();
    }

    public ActivityStatsApi getPveStatsForGivenCharacter(final CharacterData character) {
        return restTemplate
                .exchange(getCorrectedApiAddressWithReplacements(pveApiAddress, character),
                        HttpMethod.GET, httpConfig.getHttpEntity(), ActivityStatsApi.class, 1)
                .getBody();
    }

    private String getCorrectedApiAddressWithReplacements(final String address, final CharacterData character) {
        return address
                .replace("{membershipType}", character.getMembershipType().toString())
                .replace("{membershipId}", character.getMembershipId())
                .replace("{characterId}", character.getCharacterId());
    }
}
