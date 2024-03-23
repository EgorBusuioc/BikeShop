package com.example.bikeshop.sevices;

import com.example.bikeshop.models.Product;
import com.example.bikeshop.repositories.ProductRepository;
import com.example.bikeshop.repositories.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ProductServiceTest {

    @Mock
    private ProductRepository productRepository;

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private ProductService productService;

    @Test
    void testListProducts() {

        String title = "Test Product";
        List<Product> mockProducts = new ArrayList<>();
        when(productRepository.findByTitle(title)).thenReturn(mockProducts);


        List<Product> result = productService.listProducts(title);


        verify(productRepository).findByTitle(title);
        verify(productRepository, never()).findAll();
    }


    @Test
    void testDeleteProduct() {
        Long productId = 1L;

        productService.deleteProduct(productId);

        verify(productRepository).deleteById(productId);
    }
}