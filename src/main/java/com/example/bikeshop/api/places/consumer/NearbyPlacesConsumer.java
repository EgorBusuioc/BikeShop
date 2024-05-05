package com.example.bikeshop.api.places.consumer;

import com.example.bikeshop.api.geocoding.Location;
import com.example.bikeshop.api.places.Circle;
import com.example.bikeshop.api.places.LocationRestriction;
import lombok.Getter;
import lombok.Setter;

import java.util.Collections;
import java.util.List;

/**
 * @author EgorBusuioc
 * 22.04.2024
 */
@Getter
@Setter
public class NearbyPlacesConsumer {

    private List<String> includedTypes = Collections.singletonList("historical_landmark");
    private int maxResultCount = 13;
    private LocationRestriction locationRestriction;

    public NearbyPlacesConsumer(Location location) {
        this.locationRestriction = new LocationRestriction(new Circle(location));
    }
}
