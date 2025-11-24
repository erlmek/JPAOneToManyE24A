package org.example.jpaonetomanye24a.repositories;

import jakarta.transaction.Transactional;
import org.example.jpaonetomanye24a.model.Region;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class RegionRepositoryTest {

    @Autowired
    RegionRepository regionRepository;

    @Test
    void testFemRegioner() {
        List<Region> regions = regionRepository.findAll();
        assertEquals(5, regions.size());

    }


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

    @Test
    void deleteRegion() {
        Region region = new Region();
        region.setKode("1081");
        Optional<Region> regopt = regionRepository.findById(region.getKode());
        Region reg = regopt.get();
        regionRepository.delete(reg);


        //assertTrue(regionRepository.findAll().size() < 5);

    }

}