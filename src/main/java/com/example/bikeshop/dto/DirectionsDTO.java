package com.example.bikeshop.dto;

import com.example.bikeshop.api.routes.Leg;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

/**
 * @author EgorBusuioc
 * 23.04.2024
 */
@Getter
@Setter
public class DirectionsDTO {

    private List<Leg> legs = new ArrayList<>();
}
