package com.serhatacar.userservice.dto.request;

import com.serhatacar.userservice.entity.User;
import com.serhatacar.userservice.entity.enums.UserRate;

/**
 * @author Serhat Acar
 */

public record UserReviewUpdateRequest(
                                                     Long id,
                                                     Long restaurantId,
                                                     String comment,
                                                     UserRate userRate,
                                                     User userId) {
}

