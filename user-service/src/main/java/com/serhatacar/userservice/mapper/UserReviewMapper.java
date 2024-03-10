package com.serhatacar.userservice.mapper;

import com.serhatacar.userservice.dto.request.UserReviewSaveRequest;
import com.serhatacar.userservice.dto.response.RestaurantDTO;
import com.serhatacar.userservice.dto.response.UserReviewDetailDTO;
import com.serhatacar.userservice.entity.UserReview;
import org.mapstruct.Mapper;

/**
 * @author Serhat Acar
 */
@Mapper(unmappedTargetPolicy = org.mapstruct.ReportingPolicy.IGNORE, componentModel = "spring")
public interface UserReviewMapper {
    UserReview convertToUserReview(UserReviewSaveRequest request);
    default UserReviewDetailDTO toUserReviewDetail(UserReview userReview,
                                                  RestaurantDTO restaurantDTO) {

        return UserReviewDetailDTO.builder()
                .user(userReview.getUser())
                .restaurantId(userReview.getRestaurantId())
                .userRate(userReview.getUserRate())
                .comment(userReview.getComment())
                .restaurantName(restaurantDTO.name())
                .userRate(userReview.getUserRate())
                .build();
    }
}
