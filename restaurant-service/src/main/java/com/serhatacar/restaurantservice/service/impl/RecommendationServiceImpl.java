package com.serhatacar.restaurantservice.service.impl;

import com.serhatacar.restaurantservice.dto.response.RecommendationDTO;
import com.serhatacar.restaurantservice.service.RecommendationService;
import com.serhatacar.restaurantservice.service.entityservice.RestaurantEntityService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Serhat Acar
 */
@Service
@RequiredArgsConstructor
public class RecommendationServiceImpl implements RecommendationService {

    private final RestaurantEntityService restaurantEntityService;
    /* private final UserClient userClient;*/

    @Override
    public RecommendationDTO getRecommendation(Long id) {
        return null;
    }

    @Override
    public RecommendationDTO getRecommendationByUserId(Long userId) {
        return null;
    }


    /*public RecommendationDTO getRecommendationByUserId(Long userId) {
        // Get user information
        ResponseEntity<RestResponse<UserDTO>> response  userClient.getUserById(userId);
        UserDTO user = response.getBody().getData();

        // User's location
        double userLat = user.latitude();
        double userLon = user.longitude();

        // Get all restaurants
        Iterable<Restaurant> restaurants = restaurantEntityService.getAllRestaurants();

        // Get recommendations
        List<RestaurantWithScoreDTO> recommendations = RecommendationEngine.getRecommendations(userLat, userLon, restaurants);

        // Convert Recommendation list to RecommendationDTO list
        RecommendationDTO recommendationDTO = new RecommendationDTO(user, recommendations);

        return recommendationDTO;
    }*/

    @Override
    public List<RecommendationDTO> getAllRecommendations() {
        return null;
    }

    @Override
    public void deleteRecommendation(Long id) {
        // TODO document why this method is empty
    }
}