package com.example.bikeshop.api.routes;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * @author EgorBusuioc
 * 23.04.2024
 */
@Getter
@Setter
public class RoutesLocation {

    @JsonProperty("lat")
    private double latitude;
    @JsonProperty("lng")
    private double longitude;
}
