package com.example.bikeshop.api.aqi;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

/**
 * @author EgorBusuioc
 * 21.04.2024
 */
@Getter
@Setter
public class Color {

    private double red;
    private double green;
    private double blue;
    @JsonIgnore
    private double newRed = red * 255;
    @JsonIgnore
    private double newGreen = green * 255;
    @JsonIgnore
    private double newBlue = blue * 255;
}
