package com.example.bikeshop.sevices;

import com.example.bikeshop.models.Product;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {
    private List<Product> products = new ArrayList<>();
    private Long ID = 0L;

    {
        products.add(new Product(++ID, "Specialized", 17511, 15, 3000, "USA"));
        products.add(new Product(++ID, "Cube", 51479, 14, 5000, "Germany"));
    }

    public List<Product> listProducts(){
        return products;
    }

    public void saveProduct(Product product) {
        product.setId(++ID);
        products.add(product);
    }

    public void deleteProduct(Long id) {
        products.removeIf(product -> product.getId().equals(id));
    }

    public Product getProductById(Long id) {
        for (Product product : products) {
            if (product.getId().equals(id)) return product;
        }
        return null;
    }
}
