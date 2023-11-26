package com.example.bikeshop.models;

import lombok.*;

@Data
@AllArgsConstructor
public class Product {
    private Long id;
    private String model_name;
    private int article_number;
    private int quantity_in_stock;
    private int price;
    private String description;
}
