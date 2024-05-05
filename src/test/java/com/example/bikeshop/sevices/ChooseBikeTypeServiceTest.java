package com.example.bikeshop.sevices;

import com.example.bikeshop.dto.DirectionsDTO;
import com.example.bikeshop.api.geocoding.Location;
import com.example.bikeshop.api.places.consumer.NearbyPlacesConsumer;
import com.example.bikeshop.dto.GeocodingDTO;
import com.example.bikeshop.dto.NearbyPlacesDTO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
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
    private final String DIRECTIONS_URL = "https://maps.googleapis.com/maps/api/directions/json?origin=%s&destination=%s&waypoints=";
    private final String ELEVATION_URL = "https://maps.googleapis.com/maps/api/elevation/json?locations=%s%2C%s";
    private final RestTemplate restTemplate = new RestTemplate();
    private final ObjectMapper objectMapper = new ObjectMapper();

//    @Test
//    public void testJsonElevation() throws IOException {
//        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
//
//        String responce = restTemplate.getForObject(ELEVATION_API_URL, String.class);
//        JsonNode node = objectMapper.readTree(responce);
//        JsonNode secondNode = node.path("results");
//        if (secondNode.isArray() && !secondNode.isEmpty()) {
//            // Получаем первый элемент массива
//            JsonNode resultNode = secondNode.get(0);
//            String elevationJson = resultNode.toString();
//            // Замапить полученный элемент с ElevationDTO
//            ElevationDTO elevationDTO = objectMapper.readValue(elevationJson, ElevationDTO.class);
//
//            // Теперь у вас есть объект ElevationDTO
//            System.out.println(elevationDTO.getElevation());
//            System.out.println(elevationDTO.getResolution());
//        }
//    }

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

    @Test
    public void testJsonNearbyPlaces() throws JsonProcessingException {
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        httpHeaders.set("X-Goog-Api-Key", API_KEY);
        httpHeaders.set("X-Goog-FieldMask", "places.displayName,places.photos");
        Location location = new Location(41.0082376, 28.9783589);
        NearbyPlacesConsumer nearbyPlacesConsumer = new NearbyPlacesConsumer(location);

        HttpEntity<NearbyPlacesConsumer> requestEntity = new HttpEntity<>(nearbyPlacesConsumer, httpHeaders);
        String response = restTemplate.postForObject(NEARBY_PLACES_URL, requestEntity, String.class);
        NearbyPlacesDTO nearbyPlacesDTO = new NearbyPlacesDTO();
        JsonNode rootNode = objectMapper.readTree(response);
        JsonNode resultsArray = rootNode.path("places");
        if (resultsArray.isArray() && !resultsArray.isEmpty()) {
            JsonNode firstResult = resultsArray.get(0);
            String result = firstResult.toString();
            nearbyPlacesDTO = objectMapper.readValue(result, NearbyPlacesDTO.class);
        }
    }

    @Test
    public void testJsonDirections() throws JsonProcessingException {
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        httpHeaders.set("X-Goog-Api-Key", API_KEY);
        httpHeaders.set("X-Goog-FieldMask", "places.displayName,places.photos");
        Location location = new Location(47.0104529, 28.8638103);
        NearbyPlacesConsumer nearbyPlacesConsumer = new NearbyPlacesConsumer(location);

        HttpEntity<NearbyPlacesConsumer> requestEntity = new HttpEntity<>(nearbyPlacesConsumer, httpHeaders);
        NearbyPlacesDTO response = restTemplate.postForObject(NEARBY_PLACES_URL, requestEntity, NearbyPlacesDTO.class);
        for (int i = 0; i < response.getPlaces().size(); i++)
            System.out.println(response.getPlaces().get(i).getDisplayName().getText());
        makeDirections(response);
    }

//    private String makeDirectionURL(NearbyPlacesDTO places){
//
//        String preFinalString = String.format(DIRECTIONS_URL, places.getPlaces().get(0).getDisplayName().getText(), places.getPlaces().get(1).getDisplayName().getText());
//        StringBuilder finalString = new StringBuilder(preFinalString);
//
//        for (int i = 2; i < places.getPlaces().size(); i++) {
//
//            if(i == places.getPlaces().size() - 1) {
//                finalString.append(places.getPlaces().get(i).getDisplayName().getText());
//            } else
//                finalString.append(places.getPlaces().get(i).getDisplayName().getText()).append("|");
//        }
//
//        return finalString.toString();
//    }

    private void makeDirections(NearbyPlacesDTO places) throws JsonProcessingException {
        DirectionsDTO directions = new DirectionsDTO();
        List<String> FINAL_STRINGS = makeDirectionURL(places);

        for (int i = 0; i < FINAL_STRINGS.size(); i++) {
            String response = restTemplate.getForObject(FINAL_STRINGS.get(i) + "&key=" + API_KEY, String.class);
            JsonNode rootNode = objectMapper.readTree(response);
            JsonNode resultsArray = rootNode.path("routes");

            boolean stopLoop = false;
            while (resultsArray.isArray() && resultsArray.isEmpty() && !stopLoop) {
                String URL = modifyDirectionURL(FINAL_STRINGS.get(i));
                if(URL != null) {
                    String newResponse = restTemplate.getForObject(URL + "&key=" + API_KEY, String.class);
                    rootNode = objectMapper.readTree(newResponse);
                    resultsArray = rootNode.path("routes");
                    FINAL_STRINGS.set(i, URL);
                } else
                    stopLoop = true;
            }
            if (resultsArray.isArray() && !resultsArray.isEmpty()) {
                JsonNode firstResult = resultsArray.get(0);
                String result = firstResult.toString();
                DirectionsDTO temporalDirection = objectMapper.readValue(result, DirectionsDTO.class);

                for (int j = 0; j < temporalDirection.getLegs().size(); j++)
                    directions.getLegs().add(temporalDirection.getLegs().get(j));
            }
        }
    }

    private List<String> makeDirectionURL(NearbyPlacesDTO places) {

        List<String> listOfStrings = new ArrayList<>();
        String preFinalString;
        int startLocationPosition = 0;
        int endLocationPosition = 3;

        while (startLocationPosition != endLocationPosition) {

            preFinalString = String.format(DIRECTIONS_URL, places.getPlaces().get(startLocationPosition).getDisplayName().getText(),
                    places.getPlaces().get(endLocationPosition).getDisplayName().getText());
            StringBuilder finalString = new StringBuilder(preFinalString);
            if (endLocationPosition - startLocationPosition == 3) {
                finalString.append(places.getPlaces().get(startLocationPosition + 1).getDisplayName().getText())
                        .append("|")
                        .append(places.getPlaces().get(startLocationPosition + 2).getDisplayName().getText());
                listOfStrings.add(String.valueOf(finalString));
            } else if (endLocationPosition - startLocationPosition == 2) {
                finalString.append(places.getPlaces().get(startLocationPosition + 1).getDisplayName().getText());
                listOfStrings.add(finalString.toString());
            }

            startLocationPosition = endLocationPosition;
            endLocationPosition = startLocationPosition + 3;

            boolean endLocationPositionFlag = true;
            while (endLocationPositionFlag) {
                if (places.getPlaces().size() > endLocationPosition)
                    endLocationPositionFlag = false;
                else {
                    endLocationPosition--;
                }
            }
        }
        listOfStrings.forEach(System.out::println);
        return listOfStrings;
    }

    private String modifyDirectionURL(String URL) {

        int lastIndex = URL.lastIndexOf("|");
        if (lastIndex != -1) {

            return URL.substring(0, lastIndex);
        } else {
            int lastWaypoint = URL.lastIndexOf("&waypoints");
            if (lastWaypoint != -1) {

                return URL.substring(0, lastWaypoint);
            }
        }

        return null;
    }
}
