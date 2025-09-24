package org.example.jpaonetomanye24a.controller;


import org.example.jpaonetomanye24a.model.Kommune;
import org.example.jpaonetomanye24a.repositories.KommuneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
public class KommuneRestController {

    @Autowired
    KommuneRepository kommuneRepository;

    @GetMapping("/kommuner")
    public List<Kommune> getKommuner() {
        return kommuneRepository.findAll();
    }

    @PostMapping("/kommune")
    public ResponseEntity<Kommune> postKommune(@RequestBody Kommune kommune) {
        System.out.println("Indsætter ny Kommune");
        System.out.println(kommune);
        Kommune savedKommune = kommuneRepository.save(kommune);
        if (savedKommune == null) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        } else {
            return new ResponseEntity<>(savedKommune, HttpStatus.CREATED);
        }
    }

    @GetMapping("/kommune/{kode}")
    public ResponseEntity<Kommune> getKommune(@PathVariable String kode) {
        Optional<Kommune> kommuneOpt = kommuneRepository.findById(kode);
        if (kommuneOpt.isPresent()) {
            return ResponseEntity.ok(kommuneOpt.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
