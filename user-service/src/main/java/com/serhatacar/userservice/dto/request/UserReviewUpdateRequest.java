package com.serhatacar.userservice.dto.request;

import com.serhatacar.userservice.entity.User;


import java.math.BigDecimal;

/**
 * @author Serhat Acar
 */

public record UserReviewUpdateRequest(
        Long id,
        String restaurantId,
        String comment,
        BigDecimal userRate,
        User user) {
}