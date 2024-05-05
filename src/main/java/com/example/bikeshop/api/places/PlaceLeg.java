package com.example.bikeshop.api.places;

import lombok.Getter;
import lombok.Setter;

/**
 * @author EgorBusuioc
 * 05.05.2024
 */
@Getter
@Setter
public class PlaceLeg {

    private String originAddress;
    private String destinationAddress;
    private String distanceText;
    private Double distanceValue;
    private Place originPlace;
    private Place destinationPlace;
}
