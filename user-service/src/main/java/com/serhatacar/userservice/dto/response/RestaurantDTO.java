package com.serhatacar.userservice.dto.response;

import com.serhatacar.userservice.entity.enums.Status;

import java.math.BigDecimal;

/**
 * @author Serhat Acar
 */

public record RestaurantDTO(
                             String id,
                             String name,
                             String address,
                             String phone,
                             String email,
                             String description,
                             String website,
                             String workingHours,
                             BigDecimal rate,
                             Status status

){
}
