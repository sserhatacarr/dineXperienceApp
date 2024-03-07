package com.serhatacar.restaurantservice.dto;

import com.serhatacar.restaurantservice.entity.enums.Status;

/**
 * @author Serhat Acar
 */

public record RestaurantDTO (
                             String name,
                             String address,
                             String phone,
                             String email,
                             String description,
                             String website,
                             String workingHours,
                             Status status

){
}
