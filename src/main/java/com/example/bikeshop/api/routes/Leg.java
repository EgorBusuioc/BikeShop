package com.example.bikeshop.api.routes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * @author EgorBusuioc
 * 23.04.2024
 */
@Getter
@Setter
public class Leg {

    private Distance distance;
    @JsonProperty("end_location")
    private RoutesLocation endLocation;
    @JsonProperty("start_location")
    private RoutesLocation startLocation;
    @JsonProperty("end_address")
    private String endAddress;
    @JsonProperty("start_address")
    private String startAddress;
    @JsonIgnore
    private String name;
}
