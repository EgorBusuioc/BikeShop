package com.example.bikeshop.sevices;

import com.example.bikeshop.api.elevation.ElevationDTO;
import com.example.bikeshop.dto.GeocodingDTO;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.Scanner;


/**
 * @author EgorBusuioc
 * 17.04.2024
 */
public class ChooseBikeTypeServiceTest {
    private final String ELEVATION_API_URL = "https://maps.googleapis.com/maps/api/elevation/json?locations=47.0104529,28.8638103&key=AIzaSyDG9tKy3E2y0n3gV2iSYpg5rtZH1VDXUew";
    private final String API_KEY = "AIzaSyDG9tKy3E2y0n3gV2iSYpg5rtZH1VDXUew";
    private final String GEOCODING_URL = "https://maps.googleapis.com/maps/api/geocode/json?address=";
    private final String AQI_URL = "https://airquality.googleapis.com/v1/currentConditions:lookup";
    private final String NEARBY_PLACES_URL = "https://places.googleapis.com/v1/places:searchNearby";
    private final String DIRECTIONS_URL = "https://maps.googleapis.com/maps/api/directions/json?avoid=highways&mode=DRIVING&destination=%s&origin=%s&waypoints=";
    private final String ELEVATION_URL = "https://maps.googleapis.com/maps/api/elevation/json?locations=%s%2C%s";
    private final RestTemplate restTemplate = new RestTemplate();
    private final ObjectMapper objectMapper = new ObjectMapper();

    @Test
    public void testJsonElevation() throws IOException {
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        String responce = restTemplate.getForObject(ELEVATION_API_URL, String.class);
        JsonNode node = objectMapper.readTree(responce);
        JsonNode secondNode = node.path("results");
        if (secondNode.isArray() && !secondNode.isEmpty()) {
            // Получаем первый элемент массива
            JsonNode resultNode = secondNode.get(0);
            String elevationJson = resultNode.toString();
            // Замапить полученный элемент с ElevationDTO
            ElevationDTO elevationDTO = objectMapper.readValue(elevationJson, ElevationDTO.class);

            // Теперь у вас есть объект ElevationDTO
            System.out.println(elevationDTO.getElevation());
            System.out.println(elevationDTO.getResolution());
        }
    }

    @Test
    public void testJsonGeocoding() throws IOException {
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        Scanner scanner = new Scanner(System.in);
        String location = "Chisinau";

        String response = restTemplate.getForObject(GEOCODING_URL + location + "&key=" + API_KEY, String.class);
        JsonNode rootNode = objectMapper.readTree(response);
        JsonNode resultsArray = rootNode.path("results");
        for (JsonNode result : resultsArray) {
            JsonNode typesArray = result.path("types");
            for (JsonNode type : typesArray) {
                if (type.asText().equals("country"))
                    System.out.println("null");
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
                        geocodingDTO.setLatitude(latNode.asDouble());
                    }

                    if (!lngNode.isMissingNode()) {
                        geocodingDTO.setLongitude(lngNode.asDouble());
                    }
                }
            }
        }
    }
}
