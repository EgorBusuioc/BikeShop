package com.example.bikeshop.models.api;

import com.example.bikeshop.api.places.Photo;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @author EgorBusuioc
 * 23.04.2024
 */
@Getter
@Setter
@AllArgsConstructor
public class Place {

    private String placeName;
    private String location;
    private Double elevation;
    private List<Photo> photos;
}
