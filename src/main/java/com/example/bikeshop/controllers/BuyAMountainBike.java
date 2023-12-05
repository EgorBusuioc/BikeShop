package com.example.bikeshop.controllers;

import com.example.bikeshop.repositories.ImageRepository;
import com.example.bikeshop.sevices.BuyADefaultBikeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@AllArgsConstructor
public class BuyAMountainBike {
    private final BuyADefaultBikeService buyADefaultBikeService;
    private final ImageRepository imageRepository;


    @GetMapping("/mountain-bike")
    public String buyADefaultBike(Model model) {
        model.addAttribute("products", buyADefaultBikeService.productList());
        model.addAttribute("images", imageRepository.findAll());
        return "buy-a-mountain-bike";
    }
}
