package com.example.service;

import com.example.dto.SeedDTO;
import java.util.List;

public interface SeedService {
    List<SeedDTO> getAllSeeds();
    SeedDTO getSeedById(Long id);

     SeedDTO createSeed(SeedDTO seedDTO);
     SeedDTO updateSeed(Long id, SeedDTO seedDTO);
     void deleteSeed(Long id);
//     List<SeedDTO> getSeedsByCategory(String category);
}