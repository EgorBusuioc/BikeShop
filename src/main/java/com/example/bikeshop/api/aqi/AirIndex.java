package com.example.bikeshop.api.aqi;

import lombok.Getter;
import lombok.Setter;

/**
 * @author EgorBusuioc
 * 21.04.2024
 */
@Getter
@Setter
public class AirIndex {

    private String code;
    private String displayName;
    private int aqi;
    private Color color;
    private String category;
}
