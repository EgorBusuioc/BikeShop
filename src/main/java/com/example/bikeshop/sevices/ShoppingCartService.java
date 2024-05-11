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
@Slf4j
@Transactional(readOnly = true)
@RequiredArgsConstructor
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
            log.info("Shopping cart created for user: {}", user.getEmail());
        }

        ShoppingCart shoppingCart = user.getShoppingCart();
        if (shoppingCart.getQuantity() == null) {
            shoppingCart.setQuantity(0);
            log.info("Set quantity '0' for user: {}", user.getEmail());
        }

        Product product = productService.getProductById(id);

        ShoppingCartItem shoppingCartItem = new ShoppingCartItem();
        shoppingCartItem.setProduct(product);
        log.info("User has added product '{}' to shopping cart", product.getTitle());

        product.setQuantityInStock(product.getQuantityInStock() - 1);
        log.info("Quantity of product '{}' is now {}", product.getTitle(), product.getQuantityInStock());

        if(product.getQuantityInStock() == 0) {
            product.setActive(false);
            log.info("Product '{}' has been deactivated. Quantity is '{}'", product.getTitle(), product.getQuantityInStock());
        }

        shoppingCartItem.setShoppingCart(shoppingCart);
        shoppingCart.getShoppingCartItems().add(shoppingCartItem);
        shoppingCart.setQuantity(shoppingCart.getShoppingCartItems().size());
        log.info("Quantity of shopping cart has benn updated with quantity: {}", shoppingCart.getQuantity());

        if (shoppingCart.getUser() == null)
            shoppingCart.setUser(user);

        shoppingCartRepository.save(shoppingCart);
        log.info("Shopping cart saved for user: {}", user.getEmail());
    }

    public ShoppingCart getShoppingCartByPrincipal(Principal principal) {

        User user = userService.getUserByPrincipal(principal);

        if (user.getShoppingCart() == null) {
            user.setShoppingCart(new ShoppingCart());
            if (user.getShoppingCart().getQuantity() == null)
                user.getShoppingCart().setQuantity(0);
            return user.getShoppingCart();
        }
        else {
            ShoppingCart shoppingCart = user.getShoppingCart();
            Hibernate.initialize(shoppingCart.getShoppingCartItems());
            return shoppingCart;
        }
    }

    @Transactional
    public void deleteProduct(int productIdInShoppingCart, Principal principal) {

        User user = userService.getUserByPrincipal(principal);
        Product product = Objects.requireNonNull(shoppingCartItemRepository.findById(productIdInShoppingCart).orElse(null)).getProduct();
        String sql = "DELETE FROM shopping_cart_item WHERE shopping_cart_item_id = :productIdInShoppingCart";
        entityManager.createNativeQuery(sql)
                .setParameter("productIdInShoppingCart", productIdInShoppingCart)
                .executeUpdate();

        log.info("Product '{}' has been deleted from user's shopping cart: {}", product.getTitle(), user.getEmail());

        product.setQuantityInStock(product.getQuantityInStock() + 1);
        if(!product.isActive()) {
            product.setActive(true);
            log.info("Product '{}' has been activated", product.getTitle());
        }
        ShoppingCart shoppingCart = user.getShoppingCart();
        shoppingCart.setQuantity(shoppingCart.getShoppingCartItems().size());
        log.info("Has been updated quantity in shopping cart: {}", shoppingCart.getQuantity());
    }

    @Transactional
    public void checkout(Principal principal) {

        User user = userService.getUserByPrincipal(principal);
        ShoppingCart shoppingCart = user.getShoppingCart();

        shoppingCartItemRepository.deleteAll(shoppingCart.getShoppingCartItems());
        log.info("All products have been deleted from user's shopping cart: {}", user.getEmail());

        shoppingCart.getShoppingCartItems().clear();
        shoppingCart.setQuantity(0);
        log.info("Shopping cart was refreshed for user: {}", user.getEmail());
    }
}