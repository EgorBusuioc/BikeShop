package com.example.bikeshop.dto;

import lombok.Data;

import java.util.Collections;
import java.util.List;

/**
 * @author EgorBusuioc
 * 17.04.2024
 */
@Data
public class AirQualityIndexDTO {

    private LocationDTO location;
    public static final List<String> extraComputations = Collections.singletonList("LOCAL_AQI");
}
