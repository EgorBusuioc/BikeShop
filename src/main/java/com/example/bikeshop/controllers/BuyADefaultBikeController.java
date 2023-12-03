package com.example.bikeshop.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BuyADefaultBikeController {

    @RequestMapping("/buy-a-default-bike")
    public String getMainPage() {
        return "buy-a-default-bike";
    }
}
