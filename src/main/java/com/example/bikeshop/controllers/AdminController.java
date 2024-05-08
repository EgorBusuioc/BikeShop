package com.example.bikeshop.controllers;

import com.example.bikeshop.sevices.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin")
@RequiredArgsConstructor
public class AdminController {

    private final UserService userService;

    @GetMapping
    public String showUsers(Model model) {

        model.addAttribute("users", userService.getUsers());
        return "administration/users";
    }

    @PostMapping("/user/ban/{userId}")
    public String userBan(@PathVariable("userId") int userId) {

        userService.banUser(userId);
        return "redirect:/admin";
    }
}
