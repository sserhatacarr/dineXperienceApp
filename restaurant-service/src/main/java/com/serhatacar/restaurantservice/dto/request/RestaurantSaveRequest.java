package com.serhatacar.restaurantservice.dto.request;

import com.serhatacar.restaurantservice.entity.enums.RestaurantRate;
import com.serhatacar.restaurantservice.entity.enums.Status;

/**
 * @author Serhat Acar
 */

public record RestaurantSaveRequest (
                                                String name,
                                                String address,
                                                String phone,
                                                String email,
                                                String description,
                                                String website,
                                                String workingHours,
                                                double latitude,
                                                double longitude,
                                                RestaurantRate restaurantRate,
                                                Status status) {
}
