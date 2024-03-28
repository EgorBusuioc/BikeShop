package com.example.bikeshop.sevices;

import com.example.bikeshop.models.Image;
import com.example.bikeshop.models.Product;
import com.example.bikeshop.models.ProductInformation;
import com.example.bikeshop.models.User;
import com.example.bikeshop.models.enums.ProductCategory;
import com.example.bikeshop.repositories.ProductInformationRepository;
import com.example.bikeshop.repositories.ProductRepository;
import com.example.bikeshop.repositories.UserRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.security.Principal;
import java.util.*;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
@Slf4j
public class ProductService {

    private final ProductRepository productRepository;
    private final ProductInformationRepository productInformationRepository;
    private final UserRepository userRepository;

    @PersistenceContext
    private EntityManager entityManager;

    public List<Product> findBikes(ProductCategory category) {

        if (category == null) {
            return productRepository.findAll();
        }

        Session session = entityManager.unwrap(Session.class);
        List<Product> productList = session.createQuery("SELECT p FROM Product p JOIN p.productInformation pi WHERE :category MEMBER OF p.productInformation.productCategories", Product.class)
                .setParameter("category", category)
                .getResultList();

        for (Product product : productList) {
            Hibernate.initialize(product.getProductInformation());
        }
        return productList;
    }

    @Transactional
    public void saveProduct(Product product,
                            MultipartFile file1, MultipartFile file2,
                            MultipartFile file3, MultipartFile file4,
                            MultipartFile file5, MultipartFile file6,
                            MultipartFile file7, MultipartFile file8,
                            MultipartFile file9, MultipartFile file10) throws IOException {

        List<MultipartFile> files = new ArrayList<>(Arrays.asList(file1, file2, file3, file4, file5,
                file6, file7, file8, file9, file10));
        for (MultipartFile file : files) {
            if (file != null && file.getSize() != 0) {
                Image image = toImageEntity(file);
                product.addImageToProduct(image);
                log.info("Image ({}) was added to Product", file.getName());
            }
        }

        productRepository.save(product);
        log.info("Saving new product: {}", product.getTitle());
    }

    @Transactional
    public void updateInformation(ProductInformation productToUpdate, String category, int id, int productId) {

        productToUpdate.setProductCategories(Collections.singleton(ProductCategory.valueOf(category)));
        productToUpdate.setProductInformationId(id);
        productToUpdate.setProduct(productRepository.findById(productId).orElse(null));
        productInformationRepository.save(productToUpdate);
        log.info("Update product with id: {}", productToUpdate.getProductInformationId());
    }

    public Product getProductById(int id) {

        return productRepository.findById(id).orElse(null);
    }

    public User getUserByPrincipal(Principal principal) {

        if (principal == null)
            return new User();

        return userRepository.findByEmail(principal.getName());
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
    public void deleteProduct(int id) {

        productRepository.deleteById(id);
        log.info("Product with {} id was deleted", id);
    }

    public Product findProduct(int id) {

        return productRepository.findById(id).orElse(null);
    }

    @Transactional
    public ProductInformation getProductInfo(int id) {

        Product product = productRepository.findById(id).orElse(null);

        if (product == null)
            return null;

        if (product.getProductInformation() == null) {
            ProductInformation productInformation = new ProductInformation();
            productInformation.setProduct(product);
            product.setProductInformation(productInformation);
            productRepository.save(product);
        }

        return product.getProductInformation();
    }

    public ProductCategory[] getProductCategory() {

        return ProductCategory.values();
    }
}
