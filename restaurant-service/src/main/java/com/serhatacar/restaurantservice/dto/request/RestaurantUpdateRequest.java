package com.serhatacar.restaurantservice.dto.request;

import com.serhatacar.restaurantservice.entity.enums.Status;

/**
 * @author Serhat Acar
 */

public record RestaurantUpdateRequest(
                                                    Long id,
                                                    String name,
                                                    String address,
                                                    String phone,
                                                    String email,
                                                    String description,
                                                    String website,
                                                    String workingHours,
                                                    Status status) {
}