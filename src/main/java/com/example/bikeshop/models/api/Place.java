package com.example.bikeshop.models.api;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * @author EgorBusuioc
 * 23.04.2024
 */
@Getter
@Setter
@AllArgsConstructor
public class Place {

    private String location;
    private Double elevation;
}
