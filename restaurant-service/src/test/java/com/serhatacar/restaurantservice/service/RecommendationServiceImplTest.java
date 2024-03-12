package com.serhatacar.restaurantservice.service;

import com.serhatacar.restaurantservice.client.UserClient;
import com.serhatacar.restaurantservice.common.base.RestResponse;
import com.serhatacar.restaurantservice.dto.response.RecommendationDTO;
import com.serhatacar.restaurantservice.dto.response.UserDTO;
import com.serhatacar.restaurantservice.entity.Restaurant;
import com.serhatacar.restaurantservice.service.entityservice.RestaurantEntityService;
import com.serhatacar.restaurantservice.service.impl.RecommendationServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class RecommendationServiceImplTest {

    @Mock
    private RestaurantEntityService restaurantEntityService;

    @Mock
    private UserClient userClient;

    @InjectMocks
    private RecommendationServiceImpl recommendationService;

    @Test
    public void test_getRecommendationByUserId_returnsDTOWithUserAndRestaurants() {
        // Arrange
        Long userId = 1L;
        UserDTO user = new UserDTO(userId, "John", "Doe", "john.doe@example.com", 40.7128, -74.0060);
        List<Restaurant> restaurants = new ArrayList<>();
        restaurants.add(new Restaurant(1L, "Restaurant 1", "Address 1", "1234567890", "restaurant1@example.com", "Description 1", "www.restaurant1.com", "9am-5pm", 40.7128, -74.0060, BigDecimal.valueOf(4.5), null));
        restaurants.add(new Restaurant(2L, "Restaurant 2", "Address 2", "0987654321", "restaurant2@example.com", "Description 2", "www.restaurant2.com", "10am-6pm", 40.7128, -74.0060, BigDecimal.valueOf(4.0), null));
        ResponseEntity<RestResponse<UserDTO>> response = ResponseEntity.ok(RestResponse.of(user, "User found"));
        when(userClient.getUserById(userId)).thenReturn(response);
        when(restaurantEntityService.getAllRestaurants()).thenReturn(restaurants);

        // Act
        RecommendationDTO recommendationDTO = recommendationService.getRecommendationByUserId(userId);

        // Assert
        assertEquals(user, recommendationDTO.user());
        assertEquals(restaurants.size(), recommendationDTO.restaurantList().size());
    }
}