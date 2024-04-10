package com.example.bikeshop.sevices;

import com.example.bikeshop.models.Product;
import com.example.bikeshop.models.ShoppingCart;
import com.example.bikeshop.models.ShoppingCartItem;
import com.example.bikeshop.models.User;
import com.example.bikeshop.repositories.ShoppingCartItemRepository;
import com.example.bikeshop.repositories.ShoppingCartRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.Hibernate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.security.Principal;
import java.util.Objects;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
@Slf4j
public class ShoppingCartService {

    private final ShoppingCartRepository shoppingCartRepository;
    private final ProductService productService;
    private final UserService userService;
    private final ShoppingCartItemRepository shoppingCartItemRepository;

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public void saveProductToShoppingCart(int id, Principal principal) {

        User user = userService.getUserByPrincipal(principal);

        if (user.getShoppingCart() == null) {
            user.setShoppingCart(new ShoppingCart());
        }

        ShoppingCart shoppingCart = user.getShoppingCart();
        if (shoppingCart.getQuantity() == null) {
            shoppingCart.setQuantity(0);
        }

        Product product = productService.getProductById(id);

        ShoppingCartItem shoppingCartItem = new ShoppingCartItem();
        shoppingCartItem.setProduct(product);
        product.setQuantityInStock(product.getQuantityInStock() - 1);

        if(product.getQuantityInStock() == 0) {
            product.setActive(false);
        }

        shoppingCartItem.setShoppingCart(shoppingCart);
        shoppingCart.getShoppingCartItems().add(shoppingCartItem);
        shoppingCart.setQuantity(shoppingCart.getShoppingCartItems().size());
        if (shoppingCart.getUser() == null)
            shoppingCart.setUser(user);


        shoppingCartRepository.save(shoppingCart);
    }

    public ShoppingCart getShoppingCartByPrincipal(Principal principal) {

        User user = userService.getUserByPrincipal(principal);
        ShoppingCart shoppingCart = user.getShoppingCart();

        Hibernate.initialize(shoppingCart.getShoppingCartItems());

        return shoppingCart;
    }

    @Transactional
    public void deleteProduct(int productIdInShoppingCart, Principal principal) {

        User user = userService.getUserByPrincipal(principal);
        Product product = Objects.requireNonNull(shoppingCartItemRepository.findById(productIdInShoppingCart).orElse(null)).getProduct();
        String sql = "DELETE FROM shopping_cart_item WHERE shopping_cart_item_id = :productIdInShoppingCart";
        entityManager.createNativeQuery(sql)
                .setParameter("productIdInShoppingCart", productIdInShoppingCart)
                .executeUpdate();

        log.info("Элемент корзины удален");

        product.setQuantityInStock(product.getQuantityInStock() + 1);
        if(!product.isActive())
            product.setActive(true);

        ShoppingCart shoppingCart = user.getShoppingCart();
        shoppingCart.setQuantity(shoppingCart.getShoppingCartItems().size());
        log.info("Обновлено количество товаров в корзине");
    }
}