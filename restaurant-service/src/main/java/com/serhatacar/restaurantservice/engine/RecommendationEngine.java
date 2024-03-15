package com.serhatacar.restaurantservice.engine;

import com.serhatacar.restaurantservice.dto.response.RestaurantWithScoreDTO;
import com.serhatacar.restaurantservice.entity.Restaurant;
import com.serhatacar.restaurantservice.util.RecommendationUtils;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class RecommendationEngine {

    public static List<RestaurantWithScoreDTO> getRecommendations(double userLat, double userLon, Iterable<Restaurant> restaurants) {
        List<RestaurantWithScoreDTO> recommendations = new ArrayList<>();
        DecimalFormat df = new DecimalFormat("#.##");

        for (Restaurant restaurant : restaurants) {
            double restaurantLat = restaurant.getLatitude();
            double restaurantLon = restaurant.getLongitude();
            double distance = RecommendationUtils.calculateDistance(userLat, userLon, restaurantLat, restaurantLon);


            if(distance > 10) continue; // If the distance is more than 10 km, do not recommend the restaurant !

            double score = (restaurant.getRestaurantRate().doubleValue() * 0.7) + (1 - (distance / 10)) * 0.3;
            RestaurantWithScoreDTO recommendation = new RestaurantWithScoreDTO(
                    restaurant.getId(),
                    restaurant.getName(),
                    restaurant.getAddress(),
                    restaurant.getPhone(),
                    restaurant.getEmail(),
                    restaurant.getDescription(),
                    restaurant.getWebsite(),
                    restaurant.getWorkingHours(),
                    restaurant.getLatitude(),
                    restaurant.getLongitude(),
                    restaurant.getRestaurantRate(),
                    score,
                    distance,
                    restaurant.getStatus()
            );
            recommendations.add(recommendation);
        }

        recommendations.sort((r1, r2) -> Double.compare(r2.score(), r1.score()));
        return recommendations.subList(0, Math.min(recommendations.size(), 3));
    }
}