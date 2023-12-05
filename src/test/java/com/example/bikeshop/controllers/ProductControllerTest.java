package com.example.bikeshop.controllers;

import com.example.bikeshop.sevices.ProductService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.ui.Model;

import java.security.Principal;
import java.util.Collections;

import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
class ProductControllerTest {

    @Mock
    private ProductService productService;

    @InjectMocks
    private ProductController productController;
    @Test
    void testProducts() {
        // Мокирование необходимых объектов
        Model model = mock(Model.class);
        Principal principal = mock(Principal.class);

        // Мокирование поведения методов productService
        when(productService.listProducts(anyString())).thenReturn(Collections.emptyList());
        when(productService.getUserByPrincipal(principal)).thenReturn(null);

        // Вызов метода, который будет тестироваться
        String viewName = productController.products("someTitle", principal, model);

        verify(model).addAttribute(eq("products"), any());
        verify(model).addAttribute(eq("user"), any());
    }
}