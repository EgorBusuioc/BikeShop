package com.example.bikeshop.sevices;

import com.example.bikeshop.models.Product;
import com.example.bikeshop.models.enums.ProductCategory;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * @author EgorBusuioc
 * 17.04.2024
 */
public class ChooseBikeTypeServiceTest {
    @Test
    public void getFormatCategory() {
        Product product = new Product();
        Set<ProductCategory> categories = new HashSet<>();
        categories.add(ProductCategory.ACTIVE_BIKE);
        product.setProductCategories(categories);

        if(product.getProductCategories().contains(ProductCategory.ACTIVE_BIKE)) {
            System.out.println("da");
        }
    }
}
