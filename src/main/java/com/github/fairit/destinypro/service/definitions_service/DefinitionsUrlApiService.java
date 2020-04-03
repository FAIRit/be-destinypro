package com.github.fairit.destinypro.service.definitions_service;

import com.github.fairit.destinypro.dto.destiny_manifest.DestinyManifestUrl;
import com.github.fairit.destinypro.dto.destiny_manifest.EnglishJsonURL;
import com.github.fairit.destinypro.exception.ApiNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class DefinitionsUrlApiService {

    private static final String BUNGIE_ADDRESS = "https://www.bungie.net/";

    private RestTemplate restTemplate;

    @Value("${api.bungie.address.destinymanifest}")
    private String destinyManifestApiAddress;

    @Autowired
    public DefinitionsUrlApiService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public String getClassApiAddress() {
            return BUNGIE_ADDRESS + getJsonURL().getClassDefinitionURLAddress();
    }

    public String getRaceApiAddress() {
        return BUNGIE_ADDRESS + getJsonURL().getRaceDefinitionURLAddress();
    }

    public String getGenderApiAddress() {
        return BUNGIE_ADDRESS + getJsonURL().getGenderDefinitionURLAddress();
    }

    private EnglishJsonURL getJsonURL() {
        DestinyManifestUrl destinyManifestUrl = restTemplate.getForObject(destinyManifestApiAddress, DestinyManifestUrl.class);
        if (destinyManifestUrl != null) {
            return destinyManifestUrl.getResponse().getJsonComponentPath().getEnglishJsonURL();
        }
        throw new ApiNotFoundException(EnglishJsonURL.class);
    }
}
