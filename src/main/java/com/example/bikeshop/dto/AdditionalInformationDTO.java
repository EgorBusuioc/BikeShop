package com.example.bikeshop.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

/**
 * @author EgorBusuioc
 * 24.03.2024
 */
@Getter
@Setter
public class AdditionalInformationDTO {

    private String address;

    private LocalDate dateOfBirth;

    private String phoneNumber;

    private String workingAddress;
}
