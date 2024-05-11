package com.example.bikeshop.sevices;

import com.example.bikeshop.models.*;
import com.example.bikeshop.models.enums.ProductCategory;
import com.example.bikeshop.repositories.ProductInformationRepository;
import com.example.bikeshop.repositories.ProductRepository;
import com.example.bikeshop.repositories.ShoppingCartItemRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Hibernate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.*;

@Service
@Slf4j
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;
    private final ProductInformationRepository productInformationRepository;
    private final ShoppingCartItemRepository shoppingCartItemRepository;

    public List<Product> findBikes(ProductCategory category) {

        if (category == null) {
            Set<ProductCategory> categorySet = new HashSet<>(Arrays.asList(
                    ProductCategory.S_WORKS_BIKE, ProductCategory.ACTIVE_BIKE,
                    ProductCategory.ROAD_BIKE, ProductCategory.MOUNTAIN_BIKE,
                    ProductCategory.TURBO_E_BIKE));

            return productRepository.findByProductCategoriesIn(categorySet);
        }
        Set<ProductCategory> categorySet = new HashSet<>();
        categorySet.add(category);
        List<Product> productList = productRepository.findByProductCategoriesIn(Collections.synchronizedSet(categorySet));

        for (Product product : productList)
            Hibernate.initialize(product.getProductInformation());

        return productList;
    }

    public List<Product> findAllProducts() {

        return productRepository.findAll();
    }

    public Product getProductById(int id) {

        return productRepository.findById(id).orElse(null);
    }

    @Transactional
    public ProductInformation getProductInfo(int productId) {

        Product product = productRepository.findById(productId).orElse(null);

        if (product == null)
            return null;

        if (product.getProductCategories().equals(ProductCategory.COMPONENT) || product.getProductCategories().equals(ProductCategory.EQUIPMENT))
            return null;

        if (product.getProductInformation() == null) {
            ProductInformation productInformation = new ProductInformation();
            productInformation.setProduct(product);
            product.setProductInformation(productInformation);
            productRepository.save(product);
        }

        return product.getProductInformation();
    }

    @Transactional
    public void updateInformation(ProductInformation productToUpdate, int productInformationId, int productId) {

        productToUpdate.setProductInformationId(productInformationId);
        productToUpdate.setProduct(productRepository.findById(productId).orElse(null));
        productInformationRepository.save(productToUpdate);
    }

    @Transactional
    public void saveProduct(Product product, MultipartFile[] files, String category) throws IOException {

        if (files[0].getSize() == 0)
            throw new IOException();

        boolean isFirstImage = true;

        for (MultipartFile file : files) {

            if (file != null && file.getSize() != 0) {
                Image image = toImageEntity(file);
                product.addImageToProduct(image);

                image.setPreviewImage(isFirstImage);
                isFirstImage = false;
            }
        }

        product.setProductCategories(Collections.singleton(ProductCategory.valueOf(category)));
        productRepository.save(product);
    }

    @Transactional
    public void updateProduct(int productId, Product productToUpdate) {

        Product product = productRepository.findById(productId).orElse(null);

        if (product != null &&
                (!productToUpdate.getTitle().isEmpty() || productToUpdate.getQuantityInStock() != 0 || productToUpdate.getPrice() != 0 || productToUpdate.getDiscount() != 0)) {

            if (!productToUpdate.getTitle().isEmpty())
                product.setTitle(productToUpdate.getTitle());

            if (productToUpdate.getQuantityInStock() != null)
                product.setQuantityInStock(productToUpdate.getQuantityInStock());

            if (productToUpdate.getPrice() != null)
                product.setPrice(productToUpdate.getPrice());

            if (productToUpdate.getDiscount() != null)
                product.setDiscount(productToUpdate.getDiscount());

            productRepository.save(product);
        }
    }

    public ProductCategory[] getProductCategory() {

        return ProductCategory.values();
    }

    private Image toImageEntity(MultipartFile file) throws IOException {

        Image image = new Image();
        image.setName(file.getName());
        image.setOriginalFileName(file.getOriginalFilename());
        image.setContentType(file.getContentType());
        image.setSize(file.getSize());
        image.setBytes(file.getBytes());
        return image;
    }

    @Transactional
    public boolean deleteProduct(int productId) {

        Product product = productRepository.findById(productId).orElse(null);
        if (product != null) {
            List<ShoppingCartItem> cartItems = shoppingCartItemRepository.findByProduct(product);
            if (cartItems.isEmpty()) {
                productRepository.delete(product);
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }
}
