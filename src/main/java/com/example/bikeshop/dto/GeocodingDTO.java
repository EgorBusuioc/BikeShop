package com.example.bikeshop.dto;

import lombok.*;

/**
 * @author EgorBusuioc
 * 17.04.2024
 */
@Data
public class GeocodingDTO {

    private String placeId;
    private String formattedAddress;
    private double lat;
    private double lng;
    private String type;
    private AirQualityIndexDTO airQualityIndexDTO;
}
