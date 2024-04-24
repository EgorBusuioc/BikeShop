package com.example.bikeshop.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

/**
 * @author EgorBusuioc
 * 17.04.2024
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GeocodingDTO {

    @JsonProperty("place_id")
    private String placeId;
    @JsonProperty("formatted_address")
    private String formattedAddress;
    @JsonProperty("lat")
    private double latitude;
    @JsonProperty("lng")
    private double longitude;
    private String type;
}
