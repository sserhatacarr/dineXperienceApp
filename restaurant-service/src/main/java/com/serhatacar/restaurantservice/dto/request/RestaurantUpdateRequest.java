package com.serhatacar.restaurantservice.dto.request;

import com.serhatacar.restaurantservice.entity.enums.Status;

import java.math.BigDecimal;

/**
 * @author Serhat Acar
 */

public record RestaurantUpdateRequest(
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
                                                    BigDecimal restaurantRate,
                                                    Status status) {
}
