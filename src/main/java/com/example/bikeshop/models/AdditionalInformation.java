package com.example.bikeshop.models;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

/**
 * @author EgorBusuioc
 * 23.03.2024
 */
@Entity
@Table(name = "additional_information")
@Data
public class AdditionalInformation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "additional_information_id")
    private int additionalInformationId;

    @Column(name = "address")
    private String address;

    @Column(name = "city")
    private String city;

    @Column(name = "country")
    private String country;

    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private LocalDate dateOfBirth;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "working_adress")
    private String workingAddress;

    @OneToOne()
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    private User user;

    public static LocalDate stringToDateTime(String date) {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy", new Locale("en"));
        return LocalDate.parse(date, formatter);
    }

    public boolean allFieldsAreNotNull() {

        return address != null || city != null || country != null || dateOfBirth != null || phoneNumber != null || workingAddress != null;
    }
}
