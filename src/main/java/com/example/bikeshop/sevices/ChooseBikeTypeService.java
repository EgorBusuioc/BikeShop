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
import lombok.extern.slf4j.Slf4j;
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
@Slf4j
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ChooseBikeTypeService {


    private final RestTemplate restTemplate;
    private final ObjectMapper objectMapper;
    private final String API_KEY = System.getenv("API_KEY");
    private final String GEOCODING_URL = "https://maps.googleapis.com/maps/api/geocode/json?address=";
    private final String AQI_URL = "https://airquality.googleapis.com/v1/currentConditions:lookup";
    private final String NEARBY_PLACES_URL = "https://places.googleapis.com/v1/places:searchNearby";
    private final String DIRECTIONS_URL = "https://maps.googleapis.com/maps/api/directions/json?origin=%s&destination=%s&waypoints=";
    private final String ELEVATION_URL = "https://maps.googleapis.com/maps/api/elevation/json?locations=%s,%s";

    public GeocodingDTO getBicycleType(String location) throws JsonProcessingException {

        BikeCompilation resultType = new BikeCompilation();

        GeocodingDTO geocoding = getGeocoding(location);
        if (geocoding == null)
            return null;

        Location geocodingLocation = new Location(geocoding.getLatitude(), geocoding.getLongitude());

        resultType.setLocation(geocoding.getFormattedAddress());
        resultType.setGeocoding(geocoding);
        resultType.setAqi(getAQI(geocodingLocation));

        NearbyPlacesDTO places = getNearbyPlaces(geocodingLocation);
        DirectionsDTO directions = getDirections(places);

        for (int i = 0; i < directions.getLegs().size(); i++) {
            Place firstPlace = new Place(places.getPlaces().get(i).getDisplayName().getText(),
                    directions.getLegs().get(i).getStartAddress(),
                    getElevation(directions.getLegs().get(i).getStartLocation().getLatitude(), directions.getLegs().get(i).getStartLocation().getLongitude()),
                    places.getPlaces().get(i).getPhotos());
            Place secondPlace = new Place(places.getPlaces().get(i).getDisplayName().getText(),
                    directions.getLegs().get(i).getEndAddress(),
                    getElevation(directions.getLegs().get(i).getEndLocation().getLatitude(), directions.getLegs().get(i).getEndLocation().getLongitude()),
                    places.getPlaces().get(i).getPhotos());
            resultType.getDirections().add(new Direction(firstPlace, secondPlace, directions.getLegs().get(i).getDistance().getText(), directions.getLegs().get(i).getDistance().getValue()));
        }
        return getGeocoding(location);
    }

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

    private NearbyPlacesDTO getNearbyPlaces(Location location) {

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        httpHeaders.set("X-Goog-Api-Key", API_KEY);
        httpHeaders.set("X-Goog-FieldMask", "places.displayName,places.photos");

        NearbyPlacesConsumer nearbyPlacesConsumer = new NearbyPlacesConsumer(location);

        HttpEntity<NearbyPlacesConsumer> requestEntity = new HttpEntity<>(nearbyPlacesConsumer, httpHeaders);

        return restTemplate.postForObject(NEARBY_PLACES_URL, requestEntity, NearbyPlacesDTO.class);
    }

    private DirectionsDTO getDirections(NearbyPlacesDTO places) throws JsonProcessingException {

        DirectionsDTO directions = new DirectionsDTO();

        List<String> FINAL_STRINGS = makeDirectionURL(places);

        for (int i = 0; i < FINAL_STRINGS.size(); i++) {
            String response = restTemplate.getForObject(FINAL_STRINGS.get(i) + "&key=" + API_KEY, String.class);
            JsonNode rootNode = objectMapper.readTree(response);
            JsonNode resultsArray = rootNode.path("routes");

            boolean stopLoop = false;
            while (resultsArray.isArray() && resultsArray.isEmpty() && !stopLoop) {
                String URL = modifyDirectionURL(FINAL_STRINGS.get(i));
                if (URL != null) {
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

        return directions;
    }

    private double getElevation(double latitude, double longitude) throws JsonProcessingException {

        String URL = String.format(ELEVATION_URL, latitude, longitude);
        String response = restTemplate.getForObject(URL + "&key=" + API_KEY, String.class);

        JsonNode root = objectMapper.readTree(response);
        JsonNode resultNode = root.path("results");

        if (resultNode.isArray() && !resultNode.isEmpty())
            return resultNode.get(0).path("elevation").asDouble();
        else
            return 0;
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
                listOfStrings.add(finalString.toString());
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