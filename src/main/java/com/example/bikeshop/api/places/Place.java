package com.example.bikeshop.api.places;

import com.example.bikeshop.api.geocoding.Location;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @author EgorBusuioc
 * 25.04.2024
 */
@Getter
@Setter
public class Place {

    private DisplayName displayName;
    private List<Photo> photos;
    private Location location;
}
