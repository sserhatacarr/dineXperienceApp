package com.serhatacar.userservice.dto.response;

import com.serhatacar.userservice.entity.enums.RestaurantRate;
import com.serhatacar.userservice.entity.enums.Status;

/**
 * @author Serhat Acar
 */

public record RestaurantDTO(
                             Long id,
                             String name,
                             String address,
                             String phone,
                             String email,
                             String description,
                             String website,
                             String workingHours,
                             RestaurantRate rate,
                             Status status

){
}
