package com.example.repository;

import com.example.entity.Seed;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SeedRepository extends JpaRepository<Seed, Long> {
    List<Seed> findByCategory(String category);
}
