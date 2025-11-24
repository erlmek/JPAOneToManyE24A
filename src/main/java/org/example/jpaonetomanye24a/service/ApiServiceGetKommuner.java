package org.example.jpaonetomanye24a.service;

import org.example.jpaonetomanye24a.model.Kommune;

import java.util.List;

public interface ApiServiceGetKommuner {

    List<Kommune> getKommuner();
    List<Kommune> getKommunerStartsWith(Character c);

}
