package com.example.bikeshop.sevices;

import com.example.bikeshop.api.aqi.consumer.AirQualityIndexConsumer;
import com.example.bikeshop.api.places.PlaceLeg;
import com.example.bikeshop.api.places.consumer.NearbyPlacesConsumer;
import com.example.bikeshop.dto.AirQualityIndexDTO;
import com.example.bikeshop.dto.DistanceDTO;
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
    private final String DISTANCE_URL = "https://maps.googleapis.com/maps/api/distancematrix/json?origins=%s&destinations=%s";
    private final String ELEVATION_URL = "https://maps.googleapis.com/maps/api/elevation/json?locations=%s,%s";

    public BikeCompilation getBicycleType(String location) throws JsonProcessingException {

        BikeCompilation resultType = new BikeCompilation();
        log.info("COMPILATION RESULT: Entity was created");

        GeocodingDTO geocoding = getGeocoding(location);
        if (geocoding == null) {
            log.warn("GEOCODING FAILED");
            log.info("GEOCODING FAILED: Returning null");
            return null;
        }

        Location geocodingLocation = new Location(geocoding.getLatitude(), geocoding.getLongitude());
        log.info("COMPILATION RESULT: Location entity was created");

        resultType.setLocation(geocoding.getFormattedAddress());
        log.info("COMPILATION RESULT: Formatted address was input to the main Entity");

        resultType.setGeocoding(geocoding);
        log.info("COMPILATION RESULT: Geocoding was input to the main Entity");

        resultType.setAqi(getAQI(geocodingLocation));
        log.info("COMPILATION RESULT: AQI was input to the main Entity");

        NearbyPlacesDTO places = getNearbyPlaces(geocodingLocation);
        DistanceDTO directions = getDirections(places);
        Double tripDistance = 0.0;
        double elevationChange = 0.0;
        double maxElevation = -100000000000000.0;
        double minElevation = 100000000000000.0;
        int countElevation = 0;

        for (int i = 0; i < directions.getPlacesLegList().size(); i++) {
            Place firstPlace = new Place(directions.getPlacesLegList().get(i).getOriginPlace().getDisplayName().getText(),
                    directions.getPlacesLegList().get(i).getOriginAddress(),
                    getElevation(directions.getPlacesLegList().get(i).getOriginPlace().getLocation()),
                    directions.getPlacesLegList().get(i).getOriginPlace().getPhotos());
            log.info("FIRST PLACE: For the {}) place was added: Origin Address, Elevation, Destination Address", i);

            Place secondPlace = new Place(directions.getPlacesLegList().get(i).getDestinationPlace().getDisplayName().getText(),
                    directions.getPlacesLegList().get(i).getDestinationAddress(),
                    getElevation(directions.getPlacesLegList().get(i).getDestinationPlace().getLocation()),
                    directions.getPlacesLegList().get(i).getDestinationPlace().getPhotos());
            log.info("SECOND PLACE: For the {}) place was added: Origin Address, Elevation, Destination Address", i);

            if (directions.getPlacesLegList().get(i).getDistanceValue() != null) {
                tripDistance += directions.getPlacesLegList().get(i).getDistanceValue();
                log.info("Calculating full trip distance...");
            }

            resultType.getDirections().add(new Direction(
                    firstPlace,
                    secondPlace,
                    directions.getPlacesLegList().get(i).getDistanceText(),
                    directions.getPlacesLegList().get(i).getDistanceValue(),
                    (secondPlace.getElevation() != 0 && firstPlace.getElevation() != 0) ? (secondPlace.getElevation() - firstPlace.getElevation()) : 0.0));
            log.info("COMPILATION RESULT: Add to main Entity: FIRST PLACE, SECOND PLACE, DISTANCE_TEXT, DISTANCE_VALUE, MEDIUM_ELEVATION");

            if(firstPlace.getElevation() != 0.0 && secondPlace.getElevation() != 0.0) {
                maxElevation = Math.max(maxElevation, firstPlace.getElevation());
                maxElevation = Math.max(maxElevation, secondPlace.getElevation());
                minElevation = Math.min(minElevation, firstPlace.getElevation());
                minElevation = Math.min(minElevation, secondPlace.getElevation());
            }
            log.info("MAX ELEVATION finding out...");
            log.info("MIN ELEVATION finding out...");

            if(resultType.getDirections().get(i).getAverageElevation() != 0.0){
                elevationChange += resultType.getDirections().get(i).getAverageElevation();
                countElevation++;
            }
        }

        resultType.setMaxElevation(maxElevation);
        log.info("COMPILATION RESULT: MAX - Elevation was input to the main Entity");

        resultType.setMinElevation(minElevation);
        log.info("COMPILATION RESULT: MIN - Elevation was input to the main Entity");

        resultType.setFullDistance(tripDistance);
        log.info("COMPILATION RESULT: Full distance was input to the main Entity");

        resultType.setAverageElevation(elevationChange / countElevation);
        log.info("COMPILATION RESULT: Average Elevation was input to the main Entity");

        return resultType;
    }

    private GeocodingDTO getGeocoding(String location) throws JsonProcessingException {

        String response = restTemplate.getForObject(GEOCODING_URL + location + "&key=" + API_KEY, String.class);
        JsonNode rootNode = objectMapper.readTree(response);
        log.info("GEOCODING: Server caught GEOCODING response");

        JsonNode resultsArray = rootNode.path("results");
        for (JsonNode result : resultsArray) {
            JsonNode typesArray = result.path("types");
            for (JsonNode type : typesArray) {
                if (type.asText().equals("country")){
                    log.info("GEOCODING: User wrote name of country;");
                    return null;
                }

            }
        }

        GeocodingDTO geocodingDTO = new GeocodingDTO();
        if (resultsArray.isArray() && !resultsArray.isEmpty()) {
            JsonNode firstResult = resultsArray.get(0);

            JsonNode placeIdNode = firstResult.path("place_id");
            if (!placeIdNode.isMissingNode()) {
                geocodingDTO.setPlaceId(placeIdNode.asText());
                log.info("GEOCODING: Entity has been saved 'place_id'");
            }

            JsonNode typesNode = firstResult.path("types");
            if (typesNode.isArray() && !typesNode.isEmpty()) {
                geocodingDTO.setType(typesNode.get(0).asText());
                log.info("GEOCODING: Entity has been saved 'types'");
            }

            JsonNode formattedAddressNode = firstResult.path("formatted_address");
            if (!formattedAddressNode.isMissingNode()) {
                geocodingDTO.setFormattedAddress(formattedAddressNode.asText());
                log.info("GEOCODING: Entity has been saved 'formatted_address'");
            }

            JsonNode geometryNode = firstResult.path("geometry");
            if (!geometryNode.isMissingNode()) {
                JsonNode locationNode = geometryNode.path("location");
                if (!locationNode.isMissingNode()) {
                    JsonNode latNode = locationNode.path("lat");
                    JsonNode lngNode = locationNode.path("lng");

                    if (!latNode.isMissingNode()) {
                        geocodingDTO.setLatitude(latNode.asDouble());
                        log.info("GEOCODING: Entity has been saved 'latitude'");
                    }

                    if (!lngNode.isMissingNode()) {
                        geocodingDTO.setLongitude(lngNode.asDouble());
                        log.info("GEOCODING: Entity has been saved 'longitude'");
                    }
                }
            }
        }
        log.info("GEOCODING: Geocoding done, GeocodingDTO has been created '{}'", geocodingDTO.getFormattedAddress());
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

        AirQualityIndexDTO AQIdto = restTemplate.postForObject(AQI_URL + "?key=" + API_KEY, requestEntity, AirQualityIndexDTO.class);
        log.info("AQI: Server caught AQI response");

        return AQIdto;
    }

    private NearbyPlacesDTO getNearbyPlaces(Location location) {

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        httpHeaders.set("X-Goog-Api-Key", API_KEY);
        httpHeaders.set("X-Goog-FieldMask", "places.displayName,places.photos,places.location");

        NearbyPlacesConsumer nearbyPlacesConsumer = new NearbyPlacesConsumer(location);

        HttpEntity<NearbyPlacesConsumer> requestEntity = new HttpEntity<>(nearbyPlacesConsumer, httpHeaders);

        NearbyPlacesDTO places = restTemplate.postForObject(NEARBY_PLACES_URL, requestEntity, NearbyPlacesDTO.class);
        log.info("NEARBY_PLACES: Server caught NearbyPlaces response");

        return places;
    }

    private DistanceDTO getDirections(NearbyPlacesDTO places) throws JsonProcessingException {

        DistanceDTO directions = new DistanceDTO();

        for (int i = 0; i < places.getPlaces().size(); i++) {
            if (i + 1 <= places.getPlaces().size() - 1) {
                List<com.example.bikeshop.api.places.Place> placesList = new ArrayList<>(
                        Arrays.asList(places.getPlaces().get(i), places.getPlaces().get(i + 1)));

                String FINAL_DIRECTIONS_URL = makeDirectionURL(placesList);

                String response = restTemplate.getForObject(FINAL_DIRECTIONS_URL + "&key=" + API_KEY, String.class);
                log.info("DIRECTIONS: Server caught DIRECTIONS response");

                JsonNode rootNode = objectMapper.readTree(response);

                PlaceLeg placeLeg = new PlaceLeg();
                JsonNode originAddresses = rootNode.path("origin_addresses");
                if (originAddresses.isArray() && !originAddresses.isEmpty()) {
                    placeLeg.setOriginAddress(originAddresses.get(0).asText());
                    placeLeg.setOriginPlace(placesList.get(0));
                    log.info("DIRECTIONS: Origin addresses has been saved");
                }

                JsonNode destinationAddresses = rootNode.path("destination_addresses");
                if (destinationAddresses.isArray() && !destinationAddresses.isEmpty()) {
                    placeLeg.setDestinationAddress(destinationAddresses.get(0).asText());
                    placeLeg.setDestinationPlace(placesList.get(1));
                    log.info("DIRECTIONS: Destination addresses has been saved");
                }

                JsonNode rows = rootNode.path("rows");
                if (rows.isArray() && !rows.isEmpty()) {
                    JsonNode elements = rows.get(0).path("elements");
                    if (elements.isArray() && !elements.isEmpty()) {
                        JsonNode element = elements.get(0);
                        JsonNode distance = element.path("distance");
                        if (distance.has("text")) {
                            placeLeg.setDistanceText(distance.get("text").asText());
                            log.info("DIRECTIONS: Text value of distance has been saved");
                        }
                        if (distance.has("value")) {
                            placeLeg.setDistanceValue(distance.get("value").asDouble());
                            log.info("DIRECTIONS: Double value of distance has been saved");
                        }
                    }
                }
                directions.getPlacesLegList().add(placeLeg);
            }
        }
        log.info("DIRECTIONS: Directions worked correctly and saved");
        return directions;
    }

    private double getElevation(Location location) throws JsonProcessingException {

        String URL = String.format(ELEVATION_URL, location.getLatitude(), location.getLongitude());
        String response = restTemplate.getForObject(URL + "&key=" + API_KEY, String.class);
        log.info("ELEVATION: Server caught ELEVATION response");

        JsonNode root = objectMapper.readTree(response);
        JsonNode resultNode = root.path("results");

        if (resultNode.isArray() && !resultNode.isEmpty()) {
            log.info("ELEVATION: Entity has been saved 'elevation'");
            return resultNode.get(0).path("elevation").asDouble();
        }
        else{
            log.warn("ELEVATION: Entity has not been saved 'elevation'");
            return 0;
        }
    }

    private String makeDirectionURL(List<com.example.bikeshop.api.places.Place> placesList) {

        String newString = String.format(DISTANCE_URL, placesList.get(0).getDisplayName().getText(), placesList.get(1).getDisplayName().getText());
        log.info("DIRECTION: Direction String has been created");

        return newString;
    }
}