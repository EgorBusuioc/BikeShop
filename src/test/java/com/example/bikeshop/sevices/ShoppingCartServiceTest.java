package com.example.bikeshop.sevices;

import com.example.bikeshop.models.ShoppingCart;
import com.example.bikeshop.repositories.ShoppingCartRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;


import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ShoppingCartServiceTest {

    @Mock
    private ShoppingCartRepository shoppingCartRepository;

    @InjectMocks
    private ShoppingCartService shoppingCartService;

    @Test
    void testDeleteProduct() {
        Long productId = 1L;

        shoppingCartService.deleteProduct(productId);

        verify(shoppingCartRepository, times(1)).deleteById(productId);
    }

    @Test
    void testListProductsShoppingCart() {
        List<ShoppingCart> expectedShoppingCartList = new ArrayList<>();
        expectedShoppingCartList.add(new ShoppingCart());
        expectedShoppingCartList.add(new ShoppingCart());

        when(shoppingCartRepository.findAll()).thenReturn(expectedShoppingCartList);

        List<ShoppingCart> actualShoppingCartList = shoppingCartService.listProductsShoppingCart("someTitle");

        assertEquals(expectedShoppingCartList, actualShoppingCartList);
        verify(shoppingCartRepository, times(1)).findAll();
    }
}