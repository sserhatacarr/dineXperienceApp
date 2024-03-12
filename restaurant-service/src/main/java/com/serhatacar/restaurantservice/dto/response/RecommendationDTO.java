package com.serhatacar.restaurantservice.dto.response;


import java.util.List;

/**
 * @author Serhat Acar
 */

public record RecommendationDTO(
        UserDTO user,
        List<RestaurantWithScoreDTO> restaurantList) {
}
