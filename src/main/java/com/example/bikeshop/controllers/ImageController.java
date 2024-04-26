package com.example.bikeshop.controllers;

import com.example.bikeshop.models.Image;
import com.example.bikeshop.repositories.ImageRepository;
import com.example.bikeshop.sevices.ChooseBikeTypeService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.io.ByteArrayInputStream;


@RestController
@RequiredArgsConstructor
public class ImageController {

    private final ImageRepository imageRepository;
    private final ChooseBikeTypeService chooseBikeTypeService;

    @Transactional
    @GetMapping("/images/{imageId}")
    public ResponseEntity<?> getImageById(@PathVariable("imageId") int imageId) {

        Image image = imageRepository.findById(imageId).orElse(null);

        return ResponseEntity.ok()
                .header("fileName", image.getOriginalFileName())
                .contentType(MediaType.valueOf(image.getContentType()))
                .contentLength(image.getSize())
                .body(new InputStreamResource(new ByteArrayInputStream(image.getBytes())));
    }
}
