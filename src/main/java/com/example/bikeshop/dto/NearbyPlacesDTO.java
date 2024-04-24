package com.example.bikeshop.dto;

import com.example.bikeshop.api.places.Place;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @author EgorBusuioc
 * 22.04.2024
 */
@Getter
@Setter
public class NearbyPlacesDTO {

    private List<Place> places;
}
