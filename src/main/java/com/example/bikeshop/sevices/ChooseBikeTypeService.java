package com.example.bikeshop.sevices;

import com.example.bikeshop.api.aqi.consumer.AirQualityIndexConsumer;
import com.example.bikeshop.api.places.consumer.NearbyPlacesConsumer;
import com.example.bikeshop.dto.AirQualityIndexDTO;
import com.example.bikeshop.dto.DirectionsDTO;
import com.example.bikeshop.dto.GeocodingDTO;
import com.example.bikeshop.api.geocoding.Location;
import com.example.bikeshop.dto.NearbyPlacesDTO;
import com.example.bikeshop.models.api.BikeCompilation;
import com.example.bikeshop.models.api.Direction;
import com.example.bikeshop.models.api.Place;
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
    private final String API_KEY = System.getenv("API_KEY");
    private final String GEOCODING_URL = "https://maps.googleapis.com/maps/api/geocode/json?address=";
    private final String AQI_URL = "https://airquality.googleapis.com/v1/currentConditions:lookup";
    private final String NEARBY_PLACES_URL = "https://places.googleapis.com/v1/places:searchNearby";
    private final String DIRECTIONS_URL = "https://maps.googleapis.com/maps/api/directions/json?avoid=highways&mode=DRIVING&destination=%s&origin=%s&waypoints=";
    private final String ELEVATION_URL = "https://maps.googleapis.com/maps/api/elevation/json?locations=%s%2C%s";

//    public GeocodingDTO getBicycleType(String location) throws JsonProcessingException {
//
////        BikeCompilation resultType = new BikeCompilation();
//
////        GeocodingDTO geocoding = getGeocoding(location);
////        if(geocoding == null)
////            return null;
//
////        Location geocodingLocation = new Location(geocoding.getLat(), geocoding.getLng());
////
////        resultType.setLocation(geocoding.getFormattedAddress());
////        resultType.setGeocoding(geocoding);
////        resultType.setAqi(getAQI(geocodingLocation));
////
////        System.out.println(geocoding.getLat());
////        System.out.println(geocoding.getLng());
//
//        //NearbyPlacesDTO places = getNearbyPlaces(geocodingLocation);
//        //DirectionsDTO directions = getDirections(places);
//
//        System.out.println(restTemplate.getForObject("https://maps.googleapis.com/maps/api/elevation/json?locations=47.0104529%2C28.8638103&key=AIzaSyDG9tKy3E2y0n3gV2iSYpg5rtZH1VDXUew", String.class));
////                for (int i = 0; i < directions.getRoutes().get(0).getLegs().size(); i++) {
////            System.out.println("Начало маршрута " + directions.getRoutes().get(0).getLegs().get(i).getStartAddress());
////            System.out.println("Latitude " + directions.getRoutes().get(0).getLegs().get(i).getStartLocation().getLatitude());
////            System.out.println("Longitude " + directions.getRoutes().get(0).getLegs().get(i).getStartLocation().getLongitude());
////            System.out.println("Конец маршрута " + directions.getRoutes().get(0).getLegs().get(i).getEndAddress());
////            System.out.println("Latitude " + directions.getRoutes().get(0).getLegs().get(i).getEndLocation().getLatitude());
////            System.out.println("Longitude " + directions.getRoutes().get(0).getLegs().get(i).getEndLocation().getLongitude());
////            System.out.println("Дистанция " + directions.getRoutes().get(0).getLegs().get(i).getDistance().getText());
////        }
////        for (int i = 0; i < directions.getRoutes().get(0).getLegs().size(); i++) {
////            Place firstPlace = new Place(directions.getRoutes().get(0).getLegs().get(i).getStartAddress(),
////                    getElevation(directions.getRoutes().get(0).getLegs().get(i).getStartLocation().getLatitude(), directions.getRoutes().get(0).getLegs().get(i).getStartLocation().getLongitude()));
////            Place secondPlace = new Place(directions.getRoutes().get(0).getLegs().get(i).getEndAddress(),
////                    getElevation(directions.getRoutes().get(0).getLegs().get(i).getEndLocation().getLatitude(), directions.getRoutes().get(0).getLegs().get(i).getEndLocation().getLongitude()));
////            resultType.getDirections().add(new Direction(firstPlace, secondPlace, directions.getRoutes().get(0).getLegs().get(i).getDistance().getText(), directions.getRoutes().get(0).getLegs().get(i).getDistance().getValue()));
////        }
//
//        System.out.println(resultType.toString());
//        return getGeocoding(location);
//    }

    private GeocodingDTO getGeocoding(String location) throws JsonProcessingException {

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
                        geocodingDTO.setLatitude(latNode.asDouble());
                    }

                    if (!lngNode.isMissingNode()) {
                        geocodingDTO.setLongitude(lngNode.asDouble());
                    }
                }
            }
        }

        return geocodingDTO;
    }

    private AirQualityIndexDTO getAQI(Location location) {

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);

        AirQualityIndexConsumer AQI = new AirQualityIndexConsumer(location);
        Map<String, Object> AQIData = new HashMap<>();

        AQIData.put("location", AQI.getLocation());
        AQIData.put("extraComputations", AQI.getExtraComputations());

        HttpEntity<Map<String, Object>> requestEntity = new HttpEntity<>(AQIData, httpHeaders);

        return restTemplate.postForObject(AQI_URL + "?key=" + API_KEY, requestEntity, AirQualityIndexDTO.class);
    }

    private NearbyPlacesDTO getNearbyPlaces(Location location){

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        httpHeaders.set("X-Goog-Api-Key", API_KEY);
        httpHeaders.set("X-Goog-FieldMask", "places.displayName,places.photos");

        NearbyPlacesConsumer nearbyPlacesConsumer = new NearbyPlacesConsumer(location);

        HttpEntity<NearbyPlacesConsumer> requestEntity = new HttpEntity<>(nearbyPlacesConsumer, httpHeaders);

        return restTemplate.postForObject(NEARBY_PLACES_URL, requestEntity, NearbyPlacesDTO.class);
    }

    private DirectionsDTO getDirections(NearbyPlacesDTO places) {

        String FINAL_DIRECTION_URL = makeDirectionURL(places);
        DirectionsDTO directions = restTemplate.getForObject(FINAL_DIRECTION_URL + "&key=" + API_KEY, DirectionsDTO.class);

        if (directions != null && directions.getRoutes().isEmpty()) {
            places.getPlaces().remove(places.getPlaces().size() - 1);
            return getDirections(places);
        }

        return directions;
    }
    //TODO разобарться с getElevation
    private double getElevation(double latitude, double longitude) throws JsonProcessingException {
        String URL = String.format(ELEVATION_URL, latitude, longitude);
        String response = restTemplate.getForObject("https://maps.googleapis.com/maps/api/elevation/json?locations=47.0104529%2C28.8638103&key=AIzaSyDG9tKy3E2y0n3gV2iSYpg5rtZH1VDXUew", String.class);
        System.out.println(response);
        return 0;
    }


    private String makeDirectionURL(NearbyPlacesDTO places){

        String preFinalString = String.format(DIRECTIONS_URL, places.getPlaces().get(0).getDisplayName().getText(), places.getPlaces().get(1).getDisplayName().getText());
        StringBuilder finalString = new StringBuilder(preFinalString);

        for (int i = 2; i < places.getPlaces().size(); i++) {

            if(i == places.getPlaces().size() - 1) {
                finalString.append(places.getPlaces().get(i).getDisplayName().getText());
            } else
                finalString.append(places.getPlaces().get(i).getDisplayName().getText()).append("|");
        }

        return finalString.toString();
    }
}
