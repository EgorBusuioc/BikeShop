//package com.example.bikeshop.sevices;
//
//import com.example.bikeshop.models.ShoppingCart;
//import com.example.bikeshop.models.ShoppingCartItem;
//import com.example.bikeshop.models.User;
//import com.example.bikeshop.repositories.ShoppingCartRepository;
//import lombok.RequiredArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import java.security.Principal;
//import java.util.List;
//
//@Service
//@Transactional(readOnly = true)
//@RequiredArgsConstructor
//@Slf4j
//public class ShoppingCartService {
//
//    private final ShoppingCartRepository shoppingCartRepository;
//    private final ProductService productService;
//    private final UserService userService;
//
//    @Transactional
//    public void saveProductToShoppingCart(int id, Principal principal) {
//
//        User user = productService.getUserByPrincipal(principal);
//
//        if(user.getShoppingCart() == null) {
//            user.setShoppingCart(new ShoppingCart());
//        }
//
//        ShoppingCart shoppingCart = user.getShoppingCart();
//        if(shoppingCart.getQuantity() == null) {
//            shoppingCart.setQuantity(0);
//        }
//
//        ShoppingCartItem shoppingCartItem = new ShoppingCartItem();
//        shoppingCartItem.setProduct(productService.getProductById(id));
//        shoppingCartItem.setShoppingCart(shoppingCart);
//        shoppingCart.getShoppingCartItems().add(shoppingCartItem);
//        shoppingCart.setQuantity(shoppingCart.getQuantity() + 1);
//        if(shoppingCart.getUser() == null)
//            shoppingCart.setUser(user);
//
//        shoppingCartRepository.save(shoppingCart);
//    }
//
//    @Transactional
//    public void deleteProduct(Long id) {
//        log.info("Product with id: {} was deleted from cart", id);
//        shoppingCartRepository.deleteById(id);
//    }
//
//    public List<ShoppingCart> listProductsShoppingCart(String title) {
//
//        return shoppingCartRepository.findAll();
//    }
//}
