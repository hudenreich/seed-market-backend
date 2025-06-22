package com.example.service;

import com.example.dto.SeedDTO;
import com.example.entity.Seed; // Импорт сущности Seed
import com.example.exception.ResourceNotFoundException; // Импорт исключения
import com.example.repository.SeedRepository; // Импорт репозитория Seed
import com.example.util.Mapper; // Импорт нашего Mapper
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SeedServiceImpl implements SeedService {

    private final SeedRepository seedRepository;
    private final Mapper mapper; // Внедряем наш Mapper

    public SeedServiceImpl(SeedRepository seedRepository, Mapper mapper) {
        this.seedRepository = seedRepository;
        this.mapper = mapper;
    }

    @Override
    public List<SeedDTO> getAllSeeds() {
        return seedRepository.findAll().stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public SeedDTO getSeedById(Long id) {
        Seed seed = seedRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Seed not found with id: " + id));
        return mapper.toDto(seed);
    }


    @Override
    public SeedDTO createSeed(SeedDTO seedDTO) {
        Seed seed = mapper.toEntity(seedDTO);
        Seed savedSeed = seedRepository.save(seed);
        return mapper.toDto(savedSeed);
    }

    @Override
    public SeedDTO updateSeed(Long id, SeedDTO seedDTO) {
        Seed existingSeed = seedRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Seed not found with id: " + id));
        existingSeed.setName(seedDTO.getName());
        existingSeed.setDescription(seedDTO.getDescription());
        existingSeed.setPrice(seedDTO.getPrice());
        existingSeed.setImageUrl(seedDTO.getImageUrl());
        existingSeed.setCategory(seedDTO.getCategory());

        Seed updatedSeed = seedRepository.save(existingSeed);
        return mapper.toDto(updatedSeed);
    }

    @Override
    public void deleteSeed(Long id) {
        if (!seedRepository.existsById(id)) {
            throw new ResourceNotFoundException("Seed not found with id: " + id);
        }
        seedRepository.deleteById(id);
    }

}