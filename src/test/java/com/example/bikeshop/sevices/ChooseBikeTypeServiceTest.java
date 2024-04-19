//package com.example.bikeshop.sevices;
//
//import com.example.bikeshop.dto.GeocodingDTO;
//import com.fasterxml.jackson.databind.DeserializationFeature;
//import com.fasterxml.jackson.databind.JsonNode;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import org.junit.jupiter.api.Test;
//import org.springframework.web.client.RestTemplate;
//
//import java.io.IOException;
//
//
///**
// * @author EgorBusuioc
// * 17.04.2024
// */
//public class ChooseBikeTypeServiceTest {
//    private final String API_KEY = "AIzaSyDG9tKy3E2y0n3gV2iSYpg5rtZH1VDXUew";
//    private final String GEOCODING_URL = "https://maps.googleapis.com/maps/api/geocode/json?address=";
//
//    @Test
//    public void testJsonParsing() throws IOException {
//        ObjectMapper mapper = new ObjectMapper();
//        RestTemplate restTemplate = new RestTemplate();
//        GeocodingDTO geocodingDataDTO = new GeocodingDTO();
//        String response = restTemplate.getForObject(GEOCODING_URL + "Chisinau" + "&key=" + API_KEY, String.class);
//
//        JsonNode rootNode = mapper.readTree(response);
//        JsonNode resultsArray = rootNode.path("results");
//
//        if (resultsArray.isArray() && !resultsArray.isEmpty()) {
//            JsonNode firstResult = resultsArray.get(0);
//
//            JsonNode placeIdNode = firstResult.path("place_id");
//            if (!placeIdNode.isMissingNode()) {
//                geocodingDataDTO.setPlaceId(placeIdNode.asText());
//            }
//
//            JsonNode typesNode = firstResult.path("types");
//            if (typesNode.isArray() && !typesNode.isEmpty()) {
//                geocodingDataDTO.setType(typesNode.get(0).asText());
//            }
//
//            JsonNode formattedAddressNode = firstResult.path("formatted_address");
//            if (!formattedAddressNode.isMissingNode()) {
//                geocodingDataDTO.setFormattedAddress(formattedAddressNode.asText());
//            }
//
//            JsonNode geometryNode = firstResult.path("geometry");
//            if (!geometryNode.isMissingNode()) {
//                JsonNode locationNode = geometryNode.path("location");
//                if (!locationNode.isMissingNode()) {
//                    JsonNode latNode = locationNode.path("lat");
//                    JsonNode lngNode = locationNode.path("lng");
//
//                    if (!latNode.isMissingNode()) {
//                        geocodingDataDTO.setLat(latNode.asDouble());
//                    }
//
//                    if (!lngNode.isMissingNode()) {
//                        geocodingDataDTO.setLng(lngNode.asDouble());
//                    }
//                }
//            }
//        }
//        System.out.println(geocodingDataDTO.toString());
//    }
//}
