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
    private Double fullDistance;
    private Double averageElevation;
    private double maxElevation;
    private double minElevation;

    public String returnType () {
        if (this.fullDistance > 500)
            return "Road Bike";
        if (this.fullDistance > 100 && (maxElevation - minElevation) > 50)
            return "Mountain Bike";
        if (this.fullDistance > 100 && (maxElevation - minElevation) < 50)
            return "Road Bike";
        if (this.fullDistance < 100 && (maxElevation - minElevation) < 50)
            return "Mountain Bike";

        return "Mountain Bike and Road Bike";
    }

    public String getFullDistance() {
        return fullDistance / 1000 + " km";
    }
}
