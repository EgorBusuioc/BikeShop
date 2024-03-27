package com.example.bikeshop.controllers;

import com.example.bikeshop.models.Product;
import com.example.bikeshop.models.ProductInformation;
import com.example.bikeshop.models.enums.ProductCategory;
import com.example.bikeshop.sevices.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.security.Principal;

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
        return "products/products";
    }

    @GetMapping("/product/see_information_about_product/{productId}")
    public String showInformationAboutProduct(@PathVariable("productId") int id, Model model) {

        model.addAttribute("product", productService.findProduct(id));
        return "products/product_info";
    }

    @GetMapping("product/add_product_info/{productId}")
    public String addProductInfo(@PathVariable("productId") int id, Model model) {

        model.addAttribute("productInformation", productService.getProductInfo(id));
        return "products/add_product_info";
    }

    @GetMapping("/admin")
    public String addNewProduct(@ModelAttribute("product") Product product) {

        return "products/admin";
    }

    @PostMapping("/product/create")
    public String createProduct(@RequestParam(value = "file1", required = false) MultipartFile file1, @RequestParam(value = "file2", required = false) MultipartFile file2,
                                @RequestParam(value = "file3", required = false) MultipartFile file3, @RequestParam(value = "file4", required = false) MultipartFile file4,
                                @RequestParam(value = "file5", required = false) MultipartFile file5, @RequestParam(value = "file6", required = false) MultipartFile file6,
                                @RequestParam(value = "file7", required = false) MultipartFile file7, @RequestParam(value = "file8", required = false) MultipartFile file8,
                                @RequestParam(value = "file9", required = false) MultipartFile file9, @RequestParam(value = "file10", required = false) MultipartFile file10,
                                Product product) throws IOException {

        productService.saveProduct(product, file1, file2, file3, file4, file5, file6, file7, file8, file9, file10);
        return "redirect:/products/admin";
    }

    @PostMapping("/product/add_product_information/{product_id}")
    public String addProductInformation(@PathVariable(name = "product_id") int id, @ModelAttribute("product_information") ProductInformation productToUpdate) {

        productService.updateInformation(productToUpdate, id);
        return "redirect:/admin";
    }

    @PostMapping("/product/delete/{id}")
    public String deleteProduct(@PathVariable int id) {

        productService.deleteProduct(id);
        return "redirect:/products/products";
    }
}
