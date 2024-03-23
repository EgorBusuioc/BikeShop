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
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "article_number")
    private String article_number;

    @Column(name = "quantity_in_stock")
    private String quantity_in_stock;

    @Column(name = "price")
    private int price;

    @Column(name = "discount")
    private String discount;

    @Column(name = "frame")
    private String frame;

    @Column(name = "fork")
    private String fork;

    @Column(name = "brakes")
    private String brakes;

    @Column(name = "swat")
    private String swat;

    @Column(name = "cassete")
    private String cassete;

    @ElementCollection(targetClass = BikeCategory.class, fetch = FetchType.EAGER)
    @CollectionTable(name = "bike_category", joinColumns = @JoinColumn(name = "id"))
    @Enumerated(EnumType.STRING)
    private Set<BikeCategory> bikeCategories = new HashSet<>();

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "product")
    private List<Image> images = new ArrayList<>();
    private Long previewImageId;

    private LocalDateTime dateOfCreated;
    @PrePersist
    private void init(){
        dateOfCreated = LocalDateTime.now();
    }

    public String creationDate() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMMM yyyy", new Locale("en"));
        return dateOfCreated.format(formatter);
    }

    public void addImageToProduct(Image image) {
        image.setProduct(this);
        images.add(image);
    }

}
