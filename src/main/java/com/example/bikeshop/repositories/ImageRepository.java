package com.example.bikeshop.repositories;

import com.example.bikeshop.models.Image;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ImageRepository extends JpaRepository<Image, Integer> {
}
