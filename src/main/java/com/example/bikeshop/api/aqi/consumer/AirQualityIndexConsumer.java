package com.example.bikeshop.api.aqi.consumer;

import com.example.bikeshop.api.geocoding.Location;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Collections;
import java.util.List;

/**
 * @author EgorBusuioc
 * 17.04.2024
 */
@Getter
@Setter
@AllArgsConstructor
public class AirQualityIndexConsumer {

    private Location location;
    private final List<String> extraComputations = Collections.singletonList("LOCAL_AQI");
}
