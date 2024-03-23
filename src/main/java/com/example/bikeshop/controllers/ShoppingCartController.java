package com.example.bikeshop.controllers;

import com.example.bikeshop.models.Product;
import com.example.bikeshop.models.ShoppingCart;
import com.example.bikeshop.models.User;
import com.example.bikeshop.repositories.ProductRepository;
import com.example.bikeshop.repositories.ShoppingCartRepository;
import com.example.bikeshop.repositories.UserRepository;
import com.example.bikeshop.sevices.ProductService;
import com.example.bikeshop.sevices.ShoppingCartService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;
import java.time.LocalDateTime;
import java.util.List;


@Controller
@RequiredArgsConstructor
@Slf4j
public class ShoppingCartController {
    private final ShoppingCartRepository shoppingCartRepository;
    private final UserRepository userRepository;
    private final ProductRepository productRepository;
    private final ProductService productService;
    private final ShoppingCartService shoppingCartService;

//    @PostMapping("/add_to_cart/add/{id}")
//    public String addToCart(@PathVariable String id, Principal principal) {
//        long longValue = Long.parseLong(id.replace(".", ""));
//
//        User user = userRepository.findByEmail(principal.getName());
//        Product product = productRepository.findById(longValue).orElse(null);
//
//        ShoppingCart shoppingCart = new ShoppingCart();
//        shoppingCart.setUser(user);
//        shoppingCart.setProduct(product);
//        shoppingCart.setQuantity(1);
//        shoppingCart.setDateAdded(LocalDateTime.now());
//
//
//        shoppingCartRepository.save(shoppingCart);
//        return "redirect:/shopping_cart";
//    }

    @GetMapping("/shopping_cart")
    public String shoppingCart(@RequestParam(name = "title", required = false) String title, Principal principal, Model model, User user) {
        model.addAttribute("products", shoppingCartService.listProductsShoppingCart(title));
        model.addAttribute("user", productService.getUserByPrincipal(principal));
        return "shopping";
    }

    @PostMapping("/shopping_cart/delete/{id}")
    public String deleteProductFromShoppingCart(@PathVariable String id) {
        long longValue = Long.parseLong(id.replace(".", ""));
        shoppingCartService.deleteProduct(longValue);
        return "redirect:/shopping_cart";
    }
}
