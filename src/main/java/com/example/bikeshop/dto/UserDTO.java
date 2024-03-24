package com.example.bikeshop.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * @author EgorBusuioc
 * 24.03.2024
 */

@Getter
@Setter
public class UserDTO {

    private String name;

    private String surname;

    private String email;

    private String login;

    private String password;

    private boolean active;
}
