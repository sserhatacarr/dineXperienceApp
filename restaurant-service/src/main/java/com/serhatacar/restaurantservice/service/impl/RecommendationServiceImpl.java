package com.serhatacar.restaurantservice.service.impl;

import com.serhatacar.restaurantservice.client.UserClient;
import com.serhatacar.restaurantservice.common.base.RestResponse;
import com.serhatacar.restaurantservice.dto.response.RecommendationDTO;
import com.serhatacar.restaurantservice.dto.response.RestaurantDTO;
import com.serhatacar.restaurantservice.dto.response.UserDTO;
import com.serhatacar.restaurantservice.engine.RecommendationEngine;
import com.serhatacar.restaurantservice.entity.Recommendation;
import com.serhatacar.restaurantservice.entity.Restaurant;
import com.serhatacar.restaurantservice.service.RecommendationService;
import com.serhatacar.restaurantservice.service.entityservice.RecommendationEntityService;
import com.serhatacar.restaurantservice.service.entityservice.RestaurantEntityService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Serhat Acar
 */
@Service
@RequiredArgsConstructor
public class RecommendationServiceImpl implements RecommendationService {

    private final RecommendationEntityService recommendationEntityService;
    private final RestaurantEntityService restaurantEntityService;
    private final UserClient userClient;

    @Override
    public RecommendationDTO getRecommendation(Long id) {
        return null;
    }

    @Override
    public List<RecommendationDTO> getRecommendationByUserId(Long userId) {
        // Get user information
        ResponseEntity<RestResponse<UserDTO>> response = userClient.getUserById(userId);
        UserDTO user = response.getBody().getData();

        // User's location
        double userLat = user.latitude();
        double userLon = user.longitude();

        // Get all restaurants
        List<Restaurant> restaurants = restaurantEntityService.getAllRestaurants();

        // Get recommendations
        List<Recommendation> recommendations = RecommendationEngine.getRecommendations(userLat, userLon, restaurants);

        // Convert Recommendation list to RecommendationDTO list
        List<RecommendationDTO> recommendationDTOs = recommendations.stream()
                .map(recommendation -> new RecommendationDTO(
                        recommendation.getId(),
                        user.id(),
                        recommendation.getRestaurant().getId()))

                .collect(Collectors.toList());

        return recommendationDTOs;
    }

    @Override
    public List<RecommendationDTO> getAllRecommendations() {
        return null;
    }

    @Override
    public void deleteRecommendation(Long id) {
        // TODO document why this method is empty
    }
}