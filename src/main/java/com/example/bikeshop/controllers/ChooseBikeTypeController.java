package com.example.bikeshop.controllers;

import com.example.bikeshop.sevices.ChooseBikeTypeService;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * @author EgorBusuioc
 * 17.04.2024
 */
@Controller
@RequestMapping("/choose_your_bike")
@RequiredArgsConstructor
public class ChooseBikeTypeController {

    private final ChooseBikeTypeService chooseBikeTypeService;

    @GetMapping()
    public String chooseBikeType() {

        return "choose_bike_type";
    }

    @PostMapping()
    public String chooseBikeType(@RequestParam("location") String location, Model model) throws JsonProcessingException {

        model.addAttribute("information", chooseBikeTypeService.getType(location));
        return "choose_bike_type";
    }
}
