package com.serhatacar.userservice.dto.response;

import com.serhatacar.userservice.entity.User;
import com.serhatacar.userservice.entity.enums.UserRate;
import lombok.Builder;

/**
 * @author Serhat Acar
 */
@Builder

public record UserReviewDetailDTO(
        Long id,
        User user,
        Long restaurantId,
        String restaurantName,
        String comment,
        UserRate userRate ){

}
