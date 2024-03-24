package com.example.bikeshop.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

/**
 * @author EgorBusuioc
 * 24.03.2024
 */

@Getter
@Setter
public class ProductDTO {

    private String title;

    private String quantity_in_stock;

    private int price;

    private LocalDateTime creationDate;
}
