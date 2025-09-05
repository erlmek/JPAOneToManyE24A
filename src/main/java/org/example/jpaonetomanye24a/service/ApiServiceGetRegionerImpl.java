package org.example.jpaonetomanye24a.service;


import org.example.jpaonetomanye24a.model.Region;
import org.example.jpaonetomanye24a.repositories.RegionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class ApiServiceGetRegionerImpl implements ApiServiceGetRegioner {

    @Autowired
    RegionRepository regionRepository;

    private final RestTemplate restTemplate;

    public ApiServiceGetRegionerImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    String regionUrl = "https://api.dataforsyningen.dk/regioner";


    private void saveRegioner(List<Region> regioner) {
        regioner.forEach(reg-> regionRepository.save(reg));
    }

    @Override
    public List<Region> getRegioner() {
        ResponseEntity<List<Region>> regionResponse =
                restTemplate.exchange(regionUrl,
                        HttpMethod.GET, null,
                        new ParameterizedTypeReference<List<Region>>(){
                        });
        List<Region> regioner = regionResponse.getBody();
        saveRegioner(regioner);
        return regioner;
    }
}
