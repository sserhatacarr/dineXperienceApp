package com.serhatacar.restaurantservice.engine;

import com.serhatacar.restaurantservice.dto.response.RestaurantWithScoreDTO;
import com.serhatacar.restaurantservice.entity.Restaurant;
import com.serhatacar.restaurantservice.util.RecommendationUtils;

import java.util.ArrayList;
import java.util.List;

public class RecommendationEngine {

    public static List<RestaurantWithScoreDTO> getRecommendations(double userLat, double userLon, List<Restaurant> restaurants) {
        List<RestaurantWithScoreDTO> recommendations = new ArrayList<>();

        for (Restaurant restaurant : restaurants) {
            double restaurantLat = restaurant.getLatitude();
            double restaurantLon = restaurant.getLongitude();
            double distance = RecommendationUtils.calculateDistance(userLat, userLon, restaurantLat, restaurantLon);

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
                    restaurant.getStatus()
            );
            recommendations.add(recommendation);
        }

        recommendations.sort((r1, r2) -> Double.compare(r2.score(), r1.score()));
        return recommendations.subList(0, 3);
    }
}