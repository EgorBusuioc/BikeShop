package com.example.bikeshop.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author EgorBusuioc
 * 24.03.2024
 */
@Entity
@Table(name = "shopping_cart_item")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ShoppingCartItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "shopping_cart_item_id")
    private int shoppingCartItemId;

    @ManyToOne
    @JoinColumn(name = "shopping_cart_id", referencedColumnName = "shopping_cart_id")
    private ShoppingCart shoppingCart;

    @ManyToOne
    @JoinColumn(name = "product_id", referencedColumnName = "product_id")
    private Product product;
}
