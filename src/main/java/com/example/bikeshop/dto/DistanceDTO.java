package com.example.bikeshop.dto;

import com.example.bikeshop.api.places.PlaceLeg;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

/**
 * @author EgorBusuioc
 * 23.04.2024
 */
@Getter
@Setter
public class DistanceDTO {

    private List<PlaceLeg> placesLegList = new ArrayList<>();
}
