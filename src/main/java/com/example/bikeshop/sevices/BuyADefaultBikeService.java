package com.example.bikeshop.sevices;

import com.example.bikeshop.models.Product;
import com.example.bikeshop.repositories.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class BuyADefaultBikeService {
    private final ProductRepository productRepository;

    public List<Product> productList() {

        return productRepository.findAll();
    }

}
