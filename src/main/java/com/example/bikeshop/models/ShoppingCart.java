package com.example.bikeshop.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "shopping_cart")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ShoppingCart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "shopping_cart_id")
    private int shoppingCartId;

    @Column(nullable = false)
    private Integer quantity;

    @OneToMany(mappedBy = "shoppingCart", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<ShoppingCartItem> shoppingCartItems = new ArrayList<>();

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    private User user;

    public int getFullPrice() {
        int fullPrice = 0;
        for (ShoppingCartItem shoppingCartItem : this.shoppingCartItems) {
            if(shoppingCartItem.getProduct().getDiscount() != null  && shoppingCartItem.getProduct().getDiscount() < shoppingCartItem.getProduct().getPrice())
                fullPrice += shoppingCartItem.getProduct().getDiscount();
            else
                fullPrice += shoppingCartItem.getProduct().getPrice();
        }
        return fullPrice;
    }
}
