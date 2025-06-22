package com.example.controller;

import com.example.dto.SeedDTO;
import com.example.service.SeedService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/seeds")
public class SeedController {

    private final SeedService seedService;

    public SeedController(SeedService seedService) {
        this.seedService = seedService;
    }

    @GetMapping
    public ResponseEntity<List<SeedDTO>> getAllSeeds() {
        List<SeedDTO> seeds = seedService.getAllSeeds();
        return ResponseEntity.ok(seeds);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SeedDTO> getSeedById(@PathVariable Long id) {
        SeedDTO seed = seedService.getSeedById(id);
        return ResponseEntity.ok(seed);
    }

    @PostMapping
    public ResponseEntity<SeedDTO> createSeed(@Valid @RequestBody SeedDTO seedDTO) {
        SeedDTO createdSeed = seedService.createSeed(seedDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdSeed);
    }

    @PutMapping("/{id}")
    public ResponseEntity<SeedDTO> updateSeed(@PathVariable Long id, @Valid @RequestBody SeedDTO seedDTO) {
        SeedDTO updatedSeed = seedService.updateSeed(id, seedDTO);
        return ResponseEntity.ok(updatedSeed);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSeed(@PathVariable Long id) {
        seedService.deleteSeed(id);
        return ResponseEntity.noContent().build();
    }
}