package org.example.jpaonetomanye24a.repositories;

import org.example.jpaonetomanye24a.model.Region;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class RegionRepositoryTest {

    @Autowired
    RegionRepository regionRepository;

    @Test
    void testOneRegion() {
        Region region = new Region();
        region.setKode("1024");
        region.setHref("http://localhost:8080/jpa-onetomanye24a");
        region.setNavn("Hovedstad");

        regionRepository.save(region);

        List<Region> regions = regionRepository.findAll();
        System.out.println(regions.size());
        assertTrue(regionRepository.findAll().size() >= 1);
    }

}