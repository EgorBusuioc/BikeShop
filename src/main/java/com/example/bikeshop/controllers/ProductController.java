package com.example.bikeshop.controllers;

import com.example.bikeshop.models.Product;
import com.example.bikeshop.models.enums.ProductCategory;
import com.example.bikeshop.sevices.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping
    public String getMainPage() {

        return "index";
    }
    @GetMapping("/bikes")
    public String showAllBikes(Model model) {

        model.addAttribute("bikes", productService.findBikes(null));
        return "products/bikes";
    }

    @GetMapping("/mountain-bikes")
    public String showMountainBikes(Model model) {

        model.addAttribute("mountainBikes", productService.findBikes(ProductCategory.MOUNTAIN_BIKE));
        return "products/mountain_bikes";
    }

    @GetMapping("/active-bikes")
    public String showActiveBikes(Model model) {

        model.addAttribute("activeBikes", productService.findBikes(ProductCategory.ACTIVE_BIKE));
        return "products/active_bikes";
    }

    @GetMapping("/road_bikes")
    public String showRoadBikes(Model model) {

        model.addAttribute("roadBikes", productService.findBikes(ProductCategory.ROAD_BIKE));
        return "products/road_bikes";
    }

    @GetMapping("/sworks_bikes")
    public String showSWorksBikes(Model model) {

        model.addAttribute("sworksBikes", productService.findBikes(ProductCategory.S_WORKS));
        return "products/sworks_bikes";
    }

    @GetMapping("/turbo_bikes")
    public String showTurboBikes(Model model) {

        model.addAttribute("turboBikes", productService.findBikes(ProductCategory.TURBO_E));
        return "products/turbo_bikes";
    }

    @GetMapping("/products")
    public String showProductList(Principal principal, Model model) {

        model.addAttribute("products", productService.findBikes(null));
        model.addAttribute("user", productService.getUserByPrincipal(principal));
        return "products";
    }

    @PostMapping("/product/create")
    public String createProduct(@RequestParam("file1") MultipartFile file1, @RequestParam("file2") MultipartFile file2,
                                @RequestParam("file3") MultipartFile file3, @RequestParam("file4") MultipartFile file4,
                                @RequestParam("file5") MultipartFile file5, @RequestParam("file6") MultipartFile file6,
                                @RequestParam("file7") MultipartFile file7, @RequestParam("file8") MultipartFile file8,
                                @RequestParam("file9") MultipartFile file9, @RequestParam("file10") MultipartFile file10,
                                Product product) throws IOException {

        productService.saveProduct(product, file1, file2, file3, file4, file5, file6, file7, file8, file9, file10);
        return "redirect:/admin";
    }

//    @PostMapping("/product/delete/{id}")
//    public String deleteProduct(@PathVariable String id, RedirectAttributes redirectAttributes) {
//        long longValue = Long.parseLong(id.replace(".", ""));
//        List<ShoppingCart> shoppingCartList = shoppingCartRepository.findAll();
//        ShoppingCart shoppingCart;
//        Product product;
//
//        for (int i = 0; i < shoppingCartList.size(); i++) {
//            shoppingCart = shoppingCartList.get(i);
//            product = shoppingCart.getProduct();
//            if(product.getId() == longValue){
//                redirectAttributes.addFlashAttribute("deleteProductError", "You cannot delete this product because it is in a shopping cart.");
//                return "redirect:/product";
//            }
//        }
//
//        productService.deleteProduct(longValue);
//        return "redirect:/product";
//    }
}
