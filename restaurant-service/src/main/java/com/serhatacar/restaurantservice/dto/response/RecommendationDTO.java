package com.serhatacar.restaurantservice.dto.response;



/**
 * @author Serhat Acar
 */

public record RecommendationDTO(
                                            Long id,
                                            Long userId,
                                           Long restaurantId) {
}
