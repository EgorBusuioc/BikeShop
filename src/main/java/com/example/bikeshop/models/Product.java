package com.example.bikeshop.models;

import com.example.bikeshop.models.enums.ProductCategory;
import jakarta.persistence.*;
import lombok.*;

import java.text.NumberFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

@Entity
@Table(name = "products")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private int productId;

    @Column(name = "title")
    private String title;

    @Column(name = "quantity_in_stock")
    private int quantityInStock;

    @Column(name = "article_number")
    private String articleNumber;

    @Column(name = "price")
    private int price;

    @Column(name = "discount")
    private Integer discount;

    @Column(name = "is_active")
    private boolean isActive;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "creation_date")
    private LocalDateTime creationDate;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Image> images = new ArrayList<>();

    @OneToOne(mappedBy = "product", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private ProductInformation productInformation;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<ShoppingCartItem> shoppingCartItem;

    @ElementCollection(targetClass = ProductCategory.class, fetch = FetchType.EAGER)
    @CollectionTable(name = "product_category", joinColumns = @JoinColumn(name = "product_id"))
    @Enumerated(EnumType.STRING)
    private Set<ProductCategory> productCategories = new HashSet<>();

    @PrePersist
    private void init(){
        creationDate = LocalDateTime.now();
        isActive = true;

        long currentTimeMillis = System.currentTimeMillis();
        String currentTimeString = Long.toString(currentTimeMillis);
        articleNumber = currentTimeString.substring(currentTimeString.length() - 6);
    }

    public String getFormattedDate() {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMMM yyyy", new Locale("en"));
        return creationDate.format(formatter);
    }

    public void addImageToProduct(Image image) {

        image.setProduct(this);
        images.add(image);
    }

    public String getFormattedPrice(int price) {

        NumberFormat numberFormat = NumberFormat.getNumberInstance(Locale.getDefault());
        return numberFormat.format(price) + " $";
    }
}
