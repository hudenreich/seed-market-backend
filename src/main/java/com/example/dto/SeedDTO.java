package com.example.dto;

// Если SeedDTO будет использоваться для создания/обновления, то добавьте валидацию
// import jakarta.validation.constraints.NotBlank;
// import jakarta.validation.constraints.NotNull;
// import jakarta.validation.constraints.Positive;
// import jakarta.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class SeedDTO {

    private Long id;
    private String name;
    private String description;
    private Double price;
    private String imageUrl;
    private String category;


    public SeedDTO() {
    }


    public SeedDTO(Long id, String name, String description, Double price, String imageUrl, String category) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.imageUrl = imageUrl;
        this.category = category;
    }

}