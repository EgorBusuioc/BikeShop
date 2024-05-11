package com.example.bikeshop.dto;

import com.example.bikeshop.api.aqi.AirIndex;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author EgorBusuioc
 * 21.04.2024
 */
@Getter
@Setter
public class AirQualityIndexDTO {

    private LocalDateTime dateTime;
    private String regionCode;
    private List<AirIndex> indexes;
}
