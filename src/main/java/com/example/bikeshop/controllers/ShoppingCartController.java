package com.example.bikeshop.controllers;

import com.example.bikeshop.models.ShoppingCart;
import com.example.bikeshop.models.User;
import com.example.bikeshop.sevices.ShoppingCartService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
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

    @GetMapping()
    public String shoppingCart(Model model, Principal principal) {

        model.addAttribute("shoppingCart", shoppingCartService.getShoppingCartByPrincipal(principal));
        return "products/shopping_cart";
    }

    @PostMapping("/product_details/add_to_cart/{productId}")
    public String addToCart(@PathVariable("productId") int productId, @RequestParam("lastReferer") String referer, Principal principal) {

        shoppingCartService.saveProductToShoppingCart(productId, principal);
        return "redirect:/" + referer;
    }

    @PostMapping("/delete_product/{productId}")
    public String deleteProductFromShoppingCart(@PathVariable("productId") int productIdInShoppingCart, Principal principal) {

        shoppingCartService.deleteProduct(productIdInShoppingCart, principal);
        return "redirect:/shopping_cart";
    }
}
