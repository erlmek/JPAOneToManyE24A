package org.example.jpaonetomanye24a.service;

import org.example.jpaonetomanye24a.model.Kommune;
import org.example.jpaonetomanye24a.repositories.KommuneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class ApiServiceGetKommunerImpl implements ApiServiceGetKommuner {

    @Autowired
    KommuneRepository kommuneRepository;

    private final RestTemplate restTemplate;

    public ApiServiceGetKommunerImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    String kommuneUrl = "https://api.dataforsyningen.dk/kommuner";

    private void saveKommuner(List<Kommune> Kommuner) {
        Kommuner.forEach(reg-> kommuneRepository.save(reg));
    }

    @Override
    public List<Kommune> getKommuner() {
        ResponseEntity<List<Kommune>> kommuneResponse =
                restTemplate.exchange(kommuneUrl,
                        HttpMethod.GET, null,
                        new ParameterizedTypeReference<List<Kommune>>(){
                        });
        List<Kommune> kommuner = kommuneResponse.getBody();
        saveKommuner(kommuner);
        return kommuner;
    }

    @Override
    public List<Kommune> getKommunerStartsWith(Character c) {
        List<Kommune> lstKom = kommuneRepository.findAll();
        return lstKom.stream().filter(kom -> kom.getNavn().charAt(0) == c).toList();
    }

}
