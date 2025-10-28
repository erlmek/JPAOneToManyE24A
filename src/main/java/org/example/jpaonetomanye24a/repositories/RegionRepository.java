package org.example.jpaonetomanye24a.repositories;

import org.example.jpaonetomanye24a.model.Region;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RegionRepository extends JpaRepository<Region, String> {


    Optional<Region> findRegionByNavn(String regionName);

}
