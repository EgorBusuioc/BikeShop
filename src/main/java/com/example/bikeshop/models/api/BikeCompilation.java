package com.example.bikeshop.models.api;

import com.example.bikeshop.dto.AirQualityIndexDTO;
import com.example.bikeshop.dto.GeocodingDTO;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @author EgorBusuioc
 * 23.04.2024
 */
@Data
@Getter
@Setter
public class BikeCompilation {

    private String location;
    private GeocodingDTO geocoding;
    private AirQualityIndexDTO aqi;
    private List<Direction> directions = new ArrayList<>();
}
