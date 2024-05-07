package com.example.bikeshop.repositories;

import com.example.bikeshop.models.Product;
import com.example.bikeshop.models.enums.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Set;

public interface ProductRepository extends JpaRepository<Product, Integer> {

    List<Product> findByProductCategoriesIn(Set<ProductCategory> categories);
}
