package com.example.bikeshop.controllers;

import com.example.bikeshop.models.User;
import com.example.bikeshop.sevices.ShoppingCartService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;


@Controller
@RequestMapping("/shopping_cart")
@RequiredArgsConstructor
public class ShoppingCartController {

    private final ShoppingCartService shoppingCartService;

    @PostMapping("/add_to_cart/add/{id}")
    public String addToCart(@PathVariable int id, Principal principal) {

        shoppingCartService.saveProductToShoppingCart(id, principal);
        return "redirect:/shopping_cart";
    }

    @GetMapping("/shopping_cart")
    public String shoppingCart(@RequestParam(name = "title", required = false) String title, Principal principal, Model model, User user) {

        model.addAttribute("products", shoppingCartService.listProductsShoppingCart(title));
        //model.addAttribute("user", productService.getUserByPrincipal(principal));
        return "shopping";
    }

    @PostMapping("/shopping_cart/delete/{id}")
    public String deleteProductFromShoppingCart(@PathVariable String id) {

        long longValue = Long.parseLong(id.replace(".", ""));
        shoppingCartService.deleteProduct(longValue);
        return "redirect:/shopping_cart";
    }
}
