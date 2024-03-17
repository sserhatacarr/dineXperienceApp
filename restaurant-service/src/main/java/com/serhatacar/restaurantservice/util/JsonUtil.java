package com.serhatacar.restaurantservice.util;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.serhatacar.restaurantservice.entity.Restaurant;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @author Serhat Acar
 */

public class JsonUtil {

    public static List<Restaurant> readRestaurantsFromJson() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<List<Restaurant>> typeReference = new TypeReference<>() {
        };
        InputStream inputStream = TypeReference.class.getResourceAsStream("/restaurants.json");
        return objectMapper.readValue(inputStream, typeReference);

    }

}