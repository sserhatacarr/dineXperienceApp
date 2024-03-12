package com.serhatacar.restaurantservice.dto.response;

import java.util.List;

/**
 * @author Serhat Acar
 */

public record RecommendationDTO(
                                            Long id,
                                            Long userId,
                                            List<RestaurantDTO> restaurants) {
}
