package com.example.bikeshop.controllers;

import com.example.bikeshop.models.Product;
import com.example.bikeshop.sevices.ProductService;
import com.example.bikeshop.sevices.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@Controller
@RequestMapping("/admin")
@RequiredArgsConstructor
@PreAuthorize("hasAuthority('ROLE_ADMIN')")
public class AdminController {

    private final UserService userService;
    private final ProductService productService;

    @GetMapping
    public String showUsers(Model model) {

        model.addAttribute("users", userService.getUsers());
        return "administration/users";
    }

    @GetMapping("/show_user/{user_id}")
    public String showUserInformation(@PathVariable("user_id") int user_id, Model model){

        model.addAttribute("user", userService.getUserById(user_id));
        return "administration/user_info";
    }

    @PostMapping("/user/ban/{id}")
    public String userBan(@PathVariable("id") int id) {

        userService.banUser(id);
        return "redirect:/admin";
    }

    @GetMapping("/admin")
    public String addNewProductAndShowProductList(@ModelAttribute("product") Product product,
                                                  Principal principal, Model model) {

        model.addAttribute("products", productService.findBikes(null));
        model.addAttribute("user", userService.getUserByPrincipal(principal));
        return "products/admin";
    }
}
