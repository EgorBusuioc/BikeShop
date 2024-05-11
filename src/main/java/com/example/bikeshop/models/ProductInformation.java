package com.example.bikeshop.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author EgorBusuioc
 * 23.03.2024
 */
@Entity
@Table(name = "product_informaton")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductInformation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_information_id")
    private int productInformationId;

    @Column(name = "frame")
    private String frame;

    @Column(name = "fork")
    private String fork;

    @Column(name = "brakes")
    private String brakes;

    @Column(name = "swat")
    private String swat;

    @Column(name = "cassette")
    private String cassette;

    @OneToOne
    @JoinColumn(name = "product_id", referencedColumnName = "product_id")
    private Product product;
}
