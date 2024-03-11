package com.serhatacar.userservice.mapper;

import com.serhatacar.userservice.dto.request.UserReviewSaveRequest;
import com.serhatacar.userservice.dto.request.UserReviewUpdateRequest;
import com.serhatacar.userservice.dto.response.RestaurantDTO;
import com.serhatacar.userservice.dto.response.UserReviewDetailDTO;
import com.serhatacar.userservice.entity.UserReview;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Serhat Acar
 */
@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
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

    default List<UserReviewDetailDTO> toUserReviewDetailList(List<UserReview> userReviews,
                                                            List<RestaurantDTO> restaurantDTOs) {
        return userReviews.stream().map(userReview -> {
            RestaurantDTO restaurantDTO = restaurantDTOs.stream()
                    .filter(restaurant -> restaurant.id().equals(userReview.getRestaurantId()))
                    .findFirst()
                    .orElse(null);
            return toUserReviewDetail(userReview, restaurantDTO);
        }).collect(Collectors.toList());
    }

    default void updateUserReviewFields(UserReview userReview, UserReviewUpdateRequest request) {
        userReview.setRestaurantId(request.restaurantId());
        userReview.setComment(request.comment());
        userReview.setUserRate(request.userRate());
    }
}
