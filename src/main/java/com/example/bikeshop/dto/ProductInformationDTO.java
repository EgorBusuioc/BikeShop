package com.example.bikeshop.dto;

import jakarta.persistence.Column;
import lombok.Getter;
import lombok.Setter;

/**
 * @author EgorBusuioc
 * 24.03.2024
 */

@Getter
@Setter
public class ProductInformationDTO {

    private String frame;

    private String fork;

    private String brakes;

    private String swat;

    private String cassete;
}
