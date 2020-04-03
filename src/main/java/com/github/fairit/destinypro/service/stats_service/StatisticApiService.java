package com.github.fairit.destinypro.service.stats_service;

import com.github.fairit.destinypro.config.HttpConfig;
import com.github.fairit.destinypro.dto.character.CharacterData;
import com.github.fairit.destinypro.dto.pve_pvp_stats.api.ActivityStatsApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class StatisticApiService {

    private RestTemplate restTemplate;
    private HttpConfig httpConfig;

    @Value("${api.bungie.address.playercharacterPVPstats}")
    private String pvpApiAddress;

    @Value("${api.bungie.address.playercharacterPVEstats}")
    private String pveApiAddress;

    @Autowired
    public StatisticApiService(RestTemplate restTemplate, HttpConfig httpConfig) {
        this.restTemplate = restTemplate;
        this.httpConfig = httpConfig;
    }

    public ActivityStatsApi getPvpStatsForGivenCharacter(CharacterData character) {
        return restTemplate
                .exchange(getCorrectedApiAddressWithReplacements(pvpApiAddress, character),
                        HttpMethod.GET, httpConfig.getHttpEntity(), ActivityStatsApi.class, 1)
                .getBody();
    }

    public ActivityStatsApi getPveStatsForGivenCharacter(CharacterData character) {
        return restTemplate
                .exchange(getCorrectedApiAddressWithReplacements(pveApiAddress, character),
                        HttpMethod.GET, httpConfig.getHttpEntity(), ActivityStatsApi.class, 1)
                .getBody();
    }

    private String getCorrectedApiAddressWithReplacements(String address, CharacterData character) {
        return address
                .replace("{membershipType}", character.getMembershipType().toString())
                .replace("{membershipId}", character.getMembershipId())
                .replace("{characterId}", character.getCharacterId());
    }
}
