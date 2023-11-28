package com.example.bikeshop.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "products")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "product_id")
    private Integer id;

    @Column(name = "title")
    private String title;

    @Column(name = "article_number")
    private int article_number;

    @Column(name = "quantity_in_stock")
    private int quantity_in_stock;

    @Column(name = "price")
    private int price;

    @Column(name = "description")
    private String description;
}
