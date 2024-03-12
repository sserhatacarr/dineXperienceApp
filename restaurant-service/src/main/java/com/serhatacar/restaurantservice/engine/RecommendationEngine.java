package com.serhatacar.restaurantservice.engine;


import com.serhatacar.restaurantservice.entity.Recommendation;
import com.serhatacar.restaurantservice.entity.Restaurant;
import com.serhatacar.restaurantservice.util.RecommendationUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Serhat Acar
 */
public class RecommendationEngine {

    public static List<Recommendation> getRecommendations(double userLat, double userLon, List<Restaurant> restaurants) {
        List<Recommendation> recommendations = new ArrayList<>();

        for (Restaurant restaurant : restaurants) {
            double restaurantLat = restaurant.getLatitude();
            double restaurantLon = restaurant.getLongitude();
            double distance = RecommendationUtils.calculateDistance(userLat, userLon, restaurantLat, restaurantLon);
     /*       if (distance > 10) {
                continue;
            }*/
            System.out.println("Distance: " + distance);

            Recommendation recommendation = new Recommendation();
            recommendation.setRestaurant(restaurant);
            recommendation.setScore((restaurant.getRestaurantRate().doubleValue() * 0.7) + (1 - (distance / 10)) * 0.3);
            recommendations.add(recommendation);
        }

        Collections.sort(recommendations, (r1, r2) -> Double.compare(r2.getScore(), r1.getScore()));
        return recommendations.subList(0, 3);
    }
}