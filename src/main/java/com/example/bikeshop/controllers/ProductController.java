package com.example.bikeshop.controllers;

import com.example.bikeshop.models.Product;
import com.example.bikeshop.models.ShoppingCart;
import com.example.bikeshop.repositories.ShoppingCartRepository;
import com.example.bikeshop.sevices.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.security.Principal;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;
    private final ShoppingCartRepository shoppingCartRepository;

    @GetMapping("/product")
    public String products(@RequestParam(name = "title", required = false) String title, Principal principal, Model model) {
        model.addAttribute("products", productService.listProducts(title));
        model.addAttribute("user", productService.getUserByPrincipal(principal));
        return "products";
    }

//    @PostMapping("/product/create")
//    public String createProduct(@RequestParam("file1") MultipartFile file1, @RequestParam("file2") MultipartFile file2,
//                                @RequestParam("file3") MultipartFile file3, @RequestParam("file4") MultipartFile file4, @RequestParam("file5") MultipartFile file5, Product product, Principal principal) throws IOException {
//        productService.saveProduct(principal, product, file1, file2, file3, file4, file5);
//        return "redirect:/admin";
//    }

    @PostMapping("/product/delete/{id}")
    public String deleteProduct(@PathVariable String id, RedirectAttributes redirectAttributes) {
        long longValue = Long.parseLong(id.replace(".", ""));
        List<ShoppingCart> shoppingCartList = shoppingCartRepository.findAll();
        ShoppingCart shoppingCart;
        Product product;

        for (int i = 0; i < shoppingCartList.size(); i++) {
            shoppingCart = shoppingCartList.get(i);
            product = shoppingCart.getProduct();
            if(product.getId() == longValue){
                redirectAttributes.addFlashAttribute("deleteProductError", "You cannot delete this product because it is in a shopping cart.");
                return "redirect:/product";
            }
        }

        productService.deleteProduct(longValue);
        return "redirect:/product";
    }
}
