package com.serhatacar.userservice.dto.request;

import com.serhatacar.userservice.entity.User;
import jakarta.validation.constraints.*;

import java.math.BigDecimal;

/**
 * @author Serhat Acar
 */

public record UserReviewSaveRequest(
        @NotBlank(message = "RestaurantId is mandatory")
        String restaurantId,
        @NotBlank(message = "Comment is mandatory")
        String comment,
        @NotNull(message = "UserRate is mandatory")
        @DecimalMin(value = "0.0", message = "UserRate must be equal or greater than 0")
        @DecimalMax(value = "5.0", message = "UserRate must be equal or less than 5")
        BigDecimal userRate,
        @NotNull(message = "User is mandatory")
        User user) {
}