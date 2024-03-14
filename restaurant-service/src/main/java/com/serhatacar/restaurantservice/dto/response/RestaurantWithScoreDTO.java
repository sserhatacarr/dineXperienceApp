package com.serhatacar.restaurantservice.dto.response;

import com.serhatacar.restaurantservice.entity.enums.Status;

/**
 * @author Serhat Acar
 */

public record RestaurantWithScoreDTO(
        String id,
        String name,
        String address,
        String phone,
        String email,
        String description,
        String website,
        String workingHours,
        double latitude,
        double longitude,
        Double restaurantRate,
        double score,
        double distance,
        Status status

) {
}
