package com.example.bikeshop.sevices;

import com.example.bikeshop.models.ShoppingCart;
import com.example.bikeshop.repositories.ShoppingCartRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ShoppingCartService {
    private final ShoppingCartRepository shoppingCartRepository;

    public void deleteProduct(Long id) {
        log.info("Product with id: {} was deleted from cart", id);
        shoppingCartRepository.deleteById(id);
    }

    public List<ShoppingCart> listProductsShoppingCart(String title) {

        return shoppingCartRepository.findAll();
    }
}
