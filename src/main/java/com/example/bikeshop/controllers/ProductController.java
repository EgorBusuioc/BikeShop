package com.example.bikeshop.controllers;

import com.example.bikeshop.models.Product;
import com.example.bikeshop.models.ProductInformation;
import com.example.bikeshop.models.enums.ProductCategory;
import com.example.bikeshop.sevices.ProductService;
import com.example.bikeshop.sevices.UserService;
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
    private final UserService userService;

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

        model.addAttribute("products", productService.findBikes(null));
        return "administration/products";
    }

    @PostMapping("/admin/add_product/create")
    public String createNewProduct(@ModelAttribute("product") Product product,
                                   @RequestParam(value = "file1") MultipartFile file1, @RequestParam(value = "file2", required = false) MultipartFile file2,
                                   @RequestParam(value = "file3", required = false) MultipartFile file3, @RequestParam(value = "file4", required = false) MultipartFile file4,
                                   @RequestParam(value = "file5", required = false) MultipartFile file5, @RequestParam(value = "file6", required = false) MultipartFile file6,
                                   @RequestParam(value = "file7", required = false) MultipartFile file7, @RequestParam(value = "file8", required = false) MultipartFile file8,
                                   @RequestParam(value = "file9", required = false) MultipartFile file9, @RequestParam(value = "file10", required = false) MultipartFile file10) throws IOException {

        productService.saveProduct(product, file1, file2, file3, file4, file5, file6, file7, file8, file9, file10);
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

    @GetMapping("/admin/add_product/see_information_about_product/{productId}")
    public String showInformationAboutProduct(@PathVariable("productId") int id, Model model) {

        model.addAttribute("product", productService.getProductById(id));
        return "administration/product_info";
    }

    @GetMapping("/admin/add_product/add_product_info/{productId}")
    public String addProductInfo(@PathVariable("productId") int id, Model model) {

        model.addAttribute("productInformation", productService.getProductInfo(id));
        model.addAttribute("product", productService.getProductById(id));
        model.addAttribute("productCategories", productService.getProductCategory());
        return "administration/add_product_info";
    }

    @PostMapping("/admin/add_product/add_product_info/{productInformationId}")
    public String addProductInformation(@PathVariable("productInformationId") int productInformationId,
                                        @ModelAttribute("product_information") ProductInformation productToUpdate,
                                        @RequestParam("category") String productCategory,
                                        @RequestParam("productId") int productId) {

        productService.updateInformation(productToUpdate, productCategory, productInformationId, productId);
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
