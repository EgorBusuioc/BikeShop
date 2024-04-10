package com.example.bikeshop.repositories;

import com.example.bikeshop.models.Product;
import com.example.bikeshop.models.ShoppingCartItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author EgorBusuioc
 * 10.04.2024
 */
public interface ShoppingCartItemRepository extends JpaRepository<ShoppingCartItem, Integer> {

    List<ShoppingCartItem> findByProduct(Product product);
}
