package com.github.fairit.destinypro.service.stats_service;

import com.github.fairit.destinypro.dto.character.CharacterData;
import com.github.fairit.destinypro.dto.pve_pvp_stats.PvpAndPveStats;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class StatisticApiService {

    private RestTemplate restTemplate;

    @Value("${pi.bungie.address.playercharacterPVPstats}")
    private String pvpApiAddress;

    @Value("${pi.bungie.address.playercharacterPVEstats}")
    private String pveApiAddress;

    @Autowired
    public StatisticApiService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public PvpAndPveStats getPvpStatsForGivenCharacter(CharacterData character) {
        return restTemplate
                .getForObject(getCorrectedApiAddressWithReplacements(pvpApiAddress,character), PvpAndPveStats.class);
    }

    public PvpAndPveStats getPveStatsForGivenCharacter(CharacterData character) {
        return restTemplate
                .getForObject(getCorrectedApiAddressWithReplacements(pveApiAddress,character), PvpAndPveStats.class);
    }

    private String getCorrectedApiAddressWithReplacements (String address, CharacterData character) {
        return address
                .replace("{membershipType}", character.getMembershipType().toString())
                .replace("{membershipId}", character.getMembershipId())
                .replace("{characterId}", character.getCharacterId());
    }

}
