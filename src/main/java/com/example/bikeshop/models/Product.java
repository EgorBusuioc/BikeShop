package com.example.bikeshop.models;

import com.example.bikeshop.models.enums.BikeCategory;
import jakarta.persistence.*;
import lombok.*;

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
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "product_id")
    private int productId;

    @Column(name = "title")
    private String title;

    @Column(name = "quantity_in_stock")
    private String quantity_in_stock;

    @Column(name = "price")
    private int price;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "creation_date")
    private LocalDateTime creationDate;

    @ElementCollection(targetClass = BikeCategory.class, fetch = FetchType.EAGER)
    @CollectionTable(name = "bike_category", joinColumns = @JoinColumn(name = "product_id"))
    @Enumerated(EnumType.STRING)
    private Set<BikeCategory> bikeCategories = new HashSet<>();

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Image> images = new ArrayList<>();

    @PrePersist
    private void init(){
        creationDate = LocalDateTime.now();
    }

    public String creationDate() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMMM yyyy", new Locale("en"));
        return creationDate.format(formatter);
    }

    public void addImageToProduct(Image image) {
        image.setProduct(this);
        images.add(image);
    }
}
