package com.example.util;

import com.example.dto.SeedDTO;
import com.example.entity.Seed;
import org.springframework.stereotype.Component;

@Component
public class Mapper {


    public SeedDTO toDto(Seed seed) {
        if (seed == null) {
            return null;
        }
        return new SeedDTO(
                seed.getId(),
                seed.getName(),
                seed.getDescription(),
                seed.getPrice(),
                seed.getImageUrl(),
                seed.getCategory()
        );
    }

    // Метод для преобразования SeedDTO в сущность Seed
    public Seed toEntity(SeedDTO seedDTO) {
        if (seedDTO == null) {
            return null;
        }
        Seed seed = new Seed();
        // При создании нового объекта id может быть null, если вы не хотите его устанавливать
        // Spring JPA сам сгенерирует ID при сохранении
        // seed.setId(seedDTO.getId()); // Закомментируйте, если не передаете ID при создании

        seed.setName(seedDTO.getName());
        seed.setDescription(seedDTO.getDescription());
        seed.setPrice(seedDTO.getPrice());
        seed.setImageUrl(seedDTO.getImageUrl());
        seed.setCategory(seedDTO.getCategory());
        return seed;
    }
}