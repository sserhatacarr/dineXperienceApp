package com.serhatacar.userservice.dto.response;

import com.serhatacar.userservice.entity.User;
import lombok.Builder;

import java.math.BigDecimal;

/**
 * @author Serhat Acar
 */
@Builder

public record UserReviewDetailDTO(
        Long id,
        User user,
        String restaurantId,
        String restaurantName,
        String comment,
        BigDecimal userRate ){

}
