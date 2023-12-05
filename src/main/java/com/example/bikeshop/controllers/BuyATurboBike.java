package com.example.bikeshop.controllers;

import com.example.bikeshop.repositories.ImageRepository;
import com.example.bikeshop.sevices.BuyADefaultBikeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@AllArgsConstructor
public class BuyATurboBike {
    private final BuyADefaultBikeService buyADefaultBikeService;
    private final ImageRepository imageRepository;


    @GetMapping("/turbo-bike")
    public String buyADefaultBike(Model model) {
        model.addAttribute("products", buyADefaultBikeService.productList());
        model.addAttribute("images", imageRepository.findAll());
        return "buy-a-turbo-bike";
    }
}
