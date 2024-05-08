package com.example.bikeshop.controllers;

import com.example.bikeshop.models.AdditionalInformation;
import com.example.bikeshop.models.User;
import com.example.bikeshop.sevices.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;

@Controller
@Slf4j
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/registration")
    public String registration() {

        return "authentication/registration";
    }

    @PostMapping("/registration")
    public String createUser(User user, Model model) {

        if(!userService.createUser(user)) {

            model.addAttribute("errorMessage", "User with email: (" + user.getEmail() + ") already exists");
            return "authentication/registration";
        }

        return "redirect:/login";
    }

    @GetMapping("/login")
    public String login(Principal principal, Model model, @RequestParam(name = "error", required = false) String error) {

        model.addAttribute("user", userService.getUserByPrincipal(principal));
        model.addAttribute("additionalInformation", new AdditionalInformation());

        if (error != null) {
            model.addAttribute("loginError", "The username or password is not correct");
        }

        return "authentication/login";
    }

    @PostMapping("/update-user/{userId}")
    public String updateUser(@PathVariable("userId") int userId, @RequestParam(value = "date_of_birth", required = false) String dateOfBirth,
                             AdditionalInformation additionalInformation) {

        userService.updateUser(additionalInformation, userId, dateOfBirth);
        return "redirect:/login";
    }
}
