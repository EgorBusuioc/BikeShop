package com.example.bikeshop.controllers;

import com.example.bikeshop.models.Product;
import com.example.bikeshop.models.ProductInformation;
import com.example.bikeshop.models.enums.ProductCategory;
import com.example.bikeshop.sevices.ProductService;
import com.example.bikeshop.util.ProductValidator;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Controller
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;
    private final ProductValidator productValidator;

    @GetMapping
    public String getMainPage() {

        return "index";
    }

    @GetMapping("/bikes")
    public String showAllBikes(Model model) {

        model.addAttribute("bikes", productService.findBikes(null));
        return "products/bikes";
    }

    @GetMapping("/mountain_bikes")
    public String showMountainBikes(Model model) {

        model.addAttribute("mountainBikes", productService.findBikes(ProductCategory.MOUNTAIN_BIKE));
        return "products/mountain_bikes";
    }

    @GetMapping("/active_bikes")
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

        model.addAttribute("sworksBikes", productService.findBikes(ProductCategory.S_WORKS_BIKE));
        return "products/sworks_bikes";
    }

    @GetMapping("/turbo_bikes")
    public String showTurboBikes(Model model) {

        model.addAttribute("turboBikes", productService.findBikes(ProductCategory.TURBO_E_BIKE));
        return "products/turbo_bikes";
    }

    @GetMapping("/components")
    public String showComponents(Model model) {

        model.addAttribute("components", productService.findBikes(ProductCategory.COMPONENT));
        return "products/components";
    }

    @GetMapping("/equipments")
    public String showEquipment(Model model) {

        model.addAttribute("equipments", productService.findBikes(ProductCategory.EQUIPMENT));
        return "products/equipments";
    }

    @GetMapping("/admin/products")
    public String showProducts(Model model) {

        model.addAttribute("products", productService.findAllProducts());
        return "administration/products";
    }

    @GetMapping("/product_details/{productId}")
    public String showProductDetails(@PathVariable("productId") int productId,
                                     @RequestHeader(value = "referer", required = false) String referer, Model model) {

        int lastSlashIndex = referer.lastIndexOf("/");
        String lastPart = referer.substring(lastSlashIndex + 1);

        model.addAttribute("lastReferer", lastPart);
        model.addAttribute("product", productService.getProductById(productId));
        return "products/product_details";
    }

    @GetMapping("/admin/products/add_product")
    public String addNewProduct(@ModelAttribute("product") Product product, Model model) {

        model.addAttribute("productCategories", productService.getProductCategory());
        return "administration/add_product";
    }

    @PostMapping("/admin/products/add_product")
    public String createNewProduct(@ModelAttribute("product") @Valid Product product,
                                   @RequestParam("files") MultipartFile[] files,
                                   @RequestParam("category") String productCategory, Model model,
                                   BindingResult bindingResult) {

        productValidator.validate(product, bindingResult);

        if(bindingResult.hasErrors()) {
            return "administration/add_product";
        }

        if(!product.ifDiscountLower()) {
            model.addAttribute("errorDiscount", "Discount must be lower than price");
            return "administration/add_product";
        }

        if(!product.ifQuantity()) {
            model.addAttribute("errorQuantity", "Quantity must be higher than 0");
            return "administration/add_product";
        }

        try {
            productService.saveProduct(product, files, productCategory);
        } catch (IOException e) {
            model.addAttribute("error", "You must upload at least one image");
            return "administration/add_product";
        }

        return "redirect:/admin/products";
    }

    @GetMapping("/admin/products/product_details/{productId}")
    public String showInformationAboutProduct(@PathVariable("productId") int id, Model model) {

        model.addAttribute("product", productService.getProductById(id));
        model.addAttribute("productCategories", productService.getProductCategory());
        return "administration/product_info";
    }

    @PostMapping("/admin/products/product_details/{productId}")
    public String updateInformationAboutProduct(@PathVariable("productId") int productId,
                                                @ModelAttribute("product") Product product) {

        productService.updateProduct(productId, product);
        return "redirect:/admin/products/product_details/" + productId;
    }

    @GetMapping("/admin/products/product_details/add_product_info/{productId}")
    public String addProductInfo(@PathVariable("productId") int id, Model model) {

        model.addAttribute("productInformation", productService.getProductInfo(id));
        model.addAttribute("product", productService.getProductById(id));
        return "administration/add_product_info";
    }

    @PostMapping("/admin/products/product_details/add_product_info/{productInformationId}")
    public String addProductInformation(@PathVariable("productInformationId") int productInformationId,
                                        @ModelAttribute("product_information") ProductInformation productToUpdate,
                                        @RequestParam("productId") int productId) {

        productService.updateInformation(productToUpdate, productInformationId, productId);
        return "redirect:/admin/products";
    }

    @PostMapping("/admin/products/delete/{productId}")
    public String deleteProduct(@PathVariable("productId") int productId, Model model) {

        if (productService.deleteProduct(productId))
            return "redirect:/admin/products";
        else {
            model.addAttribute("products", productService.findBikes(null));
            model.addAttribute("product", new Product());
            model.addAttribute("error", "Product with id " + productId + " cannot be deleted.");
            return "administration/products";
        }
    }
}
