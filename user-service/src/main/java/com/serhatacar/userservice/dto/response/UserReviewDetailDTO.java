package com.serhatacar.userservice.dto.response;

/**
 * @author Serhat Acar
 */

public record UserReviewDetailDTO(
        Long id,
        Long userId,
        Long restaurantId,
        String restaurantName,
        String comment,
        String userName,
        String userSurname,
        String userFullName

) {
}
