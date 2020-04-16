package com.github.fairit.destinypro.service.impl.definition;


import com.github.fairit.destinypro.dto.destinymanifest.DestinyManifestUrl;
import com.github.fairit.destinypro.dto.destinymanifest.EnglishJsonURL;
import com.github.fairit.destinypro.exception.BadDestinyManifestRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Objects;

@Service
public class DefinitionsUrlApiService {

    private static final String BUNGIE_ADDRESS = "https://www.bungie.net/";

    private final RestTemplate restTemplate;
    private final HttpEntity<?> httpEntity;

    @Value("${api.bungie.address.destinymanifest}")
    private String destinyManifestApiAddress;

    @Autowired
    public DefinitionsUrlApiService(final RestTemplate restTemplate, final HttpEntity<?> httpEntity) {
        this.restTemplate = restTemplate;
        this.httpEntity = httpEntity;

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
        var responseEntity = restTemplate
                .exchange(destinyManifestApiAddress, HttpMethod.GET, httpEntity, DestinyManifestUrl.class, 1);

        if (responseEntity.getStatusCodeValue() != 200
                || Objects.requireNonNull(responseEntity.getBody()).getResponse() == null) {
            throw new BadDestinyManifestRequestException();
        }
        return responseEntity.getBody().getResponse().getJsonComponentPath().getEnglishJsonURL();
    }
}
