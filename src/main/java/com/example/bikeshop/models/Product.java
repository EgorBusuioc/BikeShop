package com.example.bikeshop.models;

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

    @OneToOne(mappedBy = "product", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private ShoppingCartItem shoppingCartItem;

    @PrePersist
    private void init(){
        creationDate = LocalDateTime.now();
        isActive = true;
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
