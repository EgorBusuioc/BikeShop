package com.example.bikeshop.sevices;

import com.example.bikeshop.models.Image;
import com.example.bikeshop.models.Product;
import com.example.bikeshop.models.User;
import com.example.bikeshop.repositories.ProductRepository;
import com.example.bikeshop.repositories.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.security.Principal;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductService {
    private final ProductRepository productRepository;
    private final UserRepository userRepository;

    public List<Product> listProducts(String title) {
        if (title != null) return productRepository.findByTitle(title);
        return productRepository.findAll();
    }
    @Transactional
    public void saveProduct(Principal principal, Product product, MultipartFile file1, MultipartFile file2, MultipartFile file3, MultipartFile file4, MultipartFile file5) throws IOException {
        product.setUser(getUserByPrincipal(principal));
        Image image1;
        Image image2;
        Image image3;
        Image image4;
        Image image5;
        if (file1.getSize() != 0) {
            image1 = toImageEntity(file1);
            image1.setPreviewImage(true);
            product.addImageToProduct(image1);
            log.info("Preview image ({}) was added to Product", file1.getName());
        }
        if (file2.getSize() != 0) {
            image2 = toImageEntity(file2);
            product.addImageToProduct(image2);
            log.info("Second image ({}) was added to Product", file2.getName());
        }
        if (file3.getSize() != 0) {
            image3 = toImageEntity(file3);
            product.addImageToProduct(image3);
            log.info("Third image ({}) was added to Product", file3.getName());
        }
        if (file4.getSize() != 0) {
            image4 = toImageEntity(file4);
            product.addImageToProduct(image4);
            log.info("Fourth image ({}) was added to Product", file4.getName());
        }
        if (file5.getSize() != 0) {
            image5 = toImageEntity(file5);
            product.addImageToProduct(image5);
            log.info("Fifth image ({}) was added to Product", file5.getName());
        }

        log.info("Saving new product: {}, in category {}", product.getTitle(), product.getBikeCategories());

        Product productFromDb = productRepository.save(product);
        productFromDb.setPreviewImageId(productFromDb.getImages().get(0).getId());
        productRepository.save(product);
    }

    public User getUserByPrincipal(Principal principal) {
        if (principal == null) return new User();
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

    public void deleteProduct(Long id) {

        productRepository.deleteById(id);
        log.info("Product with {} id was deleted", id);
    }
}
