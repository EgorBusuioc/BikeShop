package com.example.bikeshop.controllers;

import com.example.bikeshop.models.api.BikeCompilation;
import com.example.bikeshop.sevices.ChooseBikeTypeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * @author EgorBusuioc
 * 17.04.2024
 */
@Controller
@Slf4j
@RequestMapping("/choose_your_bike")
@RequiredArgsConstructor
public class ChooseBikeTypeController {

    private final ChooseBikeTypeService chooseBikeTypeService;

    @GetMapping()
    public String chooseBikeType() {

        return "choose_bike_type";
    }

    @PostMapping()
    public String chooseBikeType(@RequestParam("location") String location, Model model) {

        try{
            BikeCompilation type = chooseBikeTypeService.getBicycleType(location);
            if(type != null)
                model.addAttribute("bikeType", chooseBikeTypeService.getBicycleType(location));
            else
                model.addAttribute("country", "country");
        }catch (Exception e){
            log.warn("User input wrong type of data");
            model.addAttribute("errorInfo", "This location has not been found");
        }
        return "choose_bike_type";
    }
}
