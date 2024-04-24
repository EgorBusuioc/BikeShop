package com.example.bikeshop.api.routes;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @author EgorBusuioc
 * 23.04.2024
 */
@Getter
@Setter
public class Route {

    private List<Leg> legs;
}
