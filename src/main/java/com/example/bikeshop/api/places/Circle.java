package com.example.bikeshop.api.places;

import com.example.bikeshop.api.geocoding.Location;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * @author EgorBusuioc
 * 22.04.2024
 */
@Getter
@Setter
@AllArgsConstructor
public class Circle {

    private Location center;
    private final int radius = 20000;
}
