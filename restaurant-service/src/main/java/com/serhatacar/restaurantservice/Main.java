package com.serhatacar.restaurantservice;

import com.serhatacar.restaurantservice.engine.RecommendationEngine;
import com.serhatacar.restaurantservice.entity.Recommendation;
import com.serhatacar.restaurantservice.entity.Restaurant;
import com.serhatacar.restaurantservice.entity.enums.Status;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Serhat Acar
 */

public class Main {
    public static void main(String[] args) {
        // Mock restaurant listesi oluştur
        List<Restaurant> restaurants = new ArrayList<>();
        restaurants.add(new Restaurant(1L, "Restaurant 1", "Address 1", "Phone 1", "Email 1", "Website 1", "Description 1", "Working Hours 1", 40.896312, -73.985428, new BigDecimal("4.5"), Status.ACTIVE));
        restaurants.add(new Restaurant(2L, "Restaurant 2", "Address 2", "Phone 2", "Email 2", "Website 2", "Description 2", "Working Hours 2", 40.748817, -73.985428, new BigDecimal("4.0"), Status.ACTIVE));
        restaurants.add(new Restaurant(3L, "Restaurant 3", "Address 3", "Phone 3", "Email 3", "Website 3", "Description 3", "Working Hours 3", 40.748817, -73.985428, new BigDecimal("4.7"), Status.ACTIVE));
        restaurants.add(new Restaurant(4L, "Restaurant 4", "Address 4", "Phone 4", "Email 4", "Website 4", "Description 4", "Working Hours 4", 40.748517, -73.985428, new BigDecimal("4.2"), Status.ACTIVE));

        // Kullanıcının konumu
        double userLat = 40.748817;
        double userLon = -73.985428;

        // Önerileri al
        List<Recommendation> recommendations = RecommendationEngine.getRecommendations(userLat, userLon, restaurants);

        // Önerileri yazdır
        for (Recommendation recommendation : recommendations) {
            System.out.println("Önerilen Restoran: " + recommendation.getRestaurant().getName() + ", Puan: " + recommendation.getScore());
        }
    }
}
