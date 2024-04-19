package com.example.bikeshop.sevices;

import com.example.bikeshop.dto.AirQualityIndexDTO;
import com.example.bikeshop.dto.GeocodingDTO;
import com.example.bikeshop.dto.LocationDTO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import java.util.*;

/**
 * @author EgorBusuioc
 * 17.04.2024
 */
@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ChooseBikeTypeService {

    private final RestTemplate restTemplate;
    private final ObjectMapper objectMapper;
    private final HttpHeaders httpHeaders;
    private final String API_KEY = "AIzaSyDG9tKy3E2y0n3gV2iSYpg5rtZH1VDXUew";
    private final String GEOCODING_URL = "https://maps.googleapis.com/maps/api/geocode/json?address=";
    private final String AQI_URL = "https://airquality.googleapis.com/v1/currentConditions:lookup";

    public GeocodingDTO getType(String location) throws JsonProcessingException {

        String response = restTemplate.getForObject(GEOCODING_URL + location + "&key=" + API_KEY, String.class);
        JsonNode rootNode = objectMapper.readTree(response);
        JsonNode resultsArray = rootNode.path("results");
        for (JsonNode result : resultsArray) {
            JsonNode typesArray = result.path("types");
            for (JsonNode type : typesArray) {
                if (type.asText().equals("country"))
                    return null;
            }
        }
        GeocodingDTO geocodingDTO = new GeocodingDTO();
        if (resultsArray.isArray() && !resultsArray.isEmpty()) {
            JsonNode firstResult = resultsArray.get(0);

            JsonNode placeIdNode = firstResult.path("place_id");
            if (!placeIdNode.isMissingNode()) {
                geocodingDTO.setPlaceId(placeIdNode.asText());
            }

            JsonNode typesNode = firstResult.path("types");
            if (typesNode.isArray() && !typesNode.isEmpty()) {
                geocodingDTO.setType(typesNode.get(0).asText());
            }

            JsonNode formattedAddressNode = firstResult.path("formatted_address");
            if (!formattedAddressNode.isMissingNode()) {
                geocodingDTO.setFormattedAddress(formattedAddressNode.asText());
            }

            JsonNode geometryNode = firstResult.path("geometry");
            if (!geometryNode.isMissingNode()) {
                JsonNode locationNode = geometryNode.path("location");
                if (!locationNode.isMissingNode()) {
                    JsonNode latNode = locationNode.path("lat");
                    JsonNode lngNode = locationNode.path("lng");

                    if (!latNode.isMissingNode()) {
                        geocodingDTO.setLat(latNode.asDouble());
                    }

                    if (!lngNode.isMissingNode()) {
                        geocodingDTO.setLng(lngNode.asDouble());
                    }
                }
            }
        }
        returnAQI(geocodingDTO.getLat(), geocodingDTO.getLng());
        return geocodingDTO;
    }

    private AirQualityIndexDTO returnAQI(double lat, double lng) {

        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        AirQualityIndexDTO AQI = new AirQualityIndexDTO();
        LocationDTO location = new LocationDTO(lat, lng);
        AQI.setLocation(location);
        Map<String, Object> AQIData = new HashMap<>();
        AQIData.put("location", AQI.getLocation());
        AQIData.put("extraComputations", AirQualityIndexDTO.extraComputations);
        System.out.println(AQIData);
        HttpEntity<Map<String, Object>> requestEntity = new HttpEntity<>(AQIData, httpHeaders);
        String response = restTemplate.postForObject(AQI_URL + "?key=" + API_KEY, requestEntity, String.class);
        System.out.println(response);
        return AQI;
    }
}
