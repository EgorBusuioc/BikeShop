package com.example.bikeshop.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * @author EgorBusuioc
 * 24.03.2024
 */

@Getter
@Setter
public class ImageDTO {

    private String name;

    private String originalFileName;

    private Long size;

    private String contentType;

    private byte[] bytes;
}
