package com.example.bikeshop.util;

import com.example.bikeshop.models.Product;
import com.example.bikeshop.repositories.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 * @author EgorBusuioc
 * 11.05.2024
 */
@Component
@RequiredArgsConstructor
public class ProductValidator implements Validator {

    private final ProductRepository productRepository;

    @Override
    public boolean supports(Class<?> clazz) {
        return Product.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {

        Product product = (Product) target;

        if(productRepository.findByTitle(product.getTitle()).isPresent()) {
            errors.rejectValue("title", null, "Product with title '" + product.getTitle() + "' already exists");
        }
    }
}
