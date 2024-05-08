package com.example.bikeshop.controllers;

import com.example.bikeshop.models.Product;
import com.example.bikeshop.models.ProductInformation;
import com.example.bikeshop.models.enums.ProductCategory;
import com.example.bikeshop.sevices.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Controller
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

    @GetMapping("/admin/add_product")
    public String addNewProductAndShowProductList(@ModelAttribute("product") Product product, Model model) {

        model.addAttribute("productCategories", productService.getProductCategory());
        model.addAttribute("products", productService.findBikes(null));
        return "administration/products";
    }

    @PostMapping("/admin/add_product/create")
    public String createNewProduct(@ModelAttribute("product") Product product,
                                   @RequestParam("files") MultipartFile[] files,
                                   @RequestParam("category") String productCategory, Model model) {
        try {
            productService.saveProduct(product, files, productCategory);
        } catch (IOException e) {
            model.addAttribute("error", "You must upload at least one image");
            return "administration/products";
        }

        return "redirect:/admin/add_product";
    }

    @GetMapping("/product_details/{productId}")
    public String showProductDetails(@PathVariable int productId,
                                     @RequestHeader(value = "referer", required = false) String referer, Model model) {

        int lastSlashIndex = referer.lastIndexOf("/");
        String lastPart = referer.substring(lastSlashIndex + 1);

        model.addAttribute("lastReferer", lastPart);
        model.addAttribute("product", productService.getProductById(productId));
        return "products/product_details";
    }

    @GetMapping("/admin/add_product/product_details/{productId}")
    public String showInformationAboutProduct(@PathVariable("productId") int id, Model model) {

        model.addAttribute("product", productService.getProductById(id));
        model.addAttribute("productCategories", productService.getProductCategory());
        return "administration/product_info";
    }

    @PostMapping("/admin/add_product/product_details/{productId}")
    public String updateInformationAboutProduct(@PathVariable("productId") int productId,
                                                @ModelAttribute("product") Product product,
                                                @RequestParam(value = "category", required = false) String category) {

        productService.updateProduct(productId, product, category);
        return "redirect:/admin/add_product/product_details/" + productId;
    }

    @GetMapping("/admin/add_product/product_details/add_product_info/{productId}")
    public String addProductInfo(@PathVariable("productId") int id, Model model) {

        model.addAttribute("productInformation", productService.getProductInfo(id));
        model.addAttribute("product", productService.getProductById(id));
        return "administration/add_product_info";
    }

    @PostMapping("/admin/add_product/product_details/add_product_info/{productInformationId}")
    public String addProductInformation(@PathVariable("productInformationId") int productInformationId,
                                        @ModelAttribute("product_information") ProductInformation productToUpdate,
                                        @RequestParam("productId") int productId) {

        productService.updateInformation(productToUpdate, productInformationId, productId);
        return "redirect:/admin/add_product";
    }

    @PostMapping("/admin/add_product/delete/{productId}")
    public String deleteProduct(@PathVariable("productId") int productId, Model model) {

        if (productService.deleteProduct(productId))
            return "redirect:/admin/add_product";
        else {
            model.addAttribute("products", productService.findBikes(null));
            model.addAttribute("product", new Product());
            model.addAttribute("error", "Product with id " + productId + " cannot be deleted.");
            return "administration/products";
        }
    }
}
