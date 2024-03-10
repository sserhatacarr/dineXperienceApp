package com.serhatacar.userservice.mapper;

import com.serhatacar.userservice.dto.request.UserReviewSaveRequest;
import com.serhatacar.userservice.dto.response.RestaurantDTO;
import com.serhatacar.userservice.dto.response.UserReviewDetailDTO;
import com.serhatacar.userservice.entity.User;
import com.serhatacar.userservice.service.entityservice.UserEntityService;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class UserReviewDetailMapper {

/*    private final UserEntityService userEntityService;
    public  UserReviewDetailDTO toUserReviewDetail(UserReviewSaveRequest request,
                                                         RestaurantDTO restaurantDTO) {
        User user = userEntityService.findByIdWithControl(request.userId());
        return UserReviewDetailDTO.builder()
                .userId(request.userId())
                .restaurantId(request.restaurantId())
                .userRate(request.userRate())
                .comment(request.comment())
                .restaurantName(restaurantDTO.name())
                .userName(request.userName())
                .userSurname(request.surname())
                .userFullName(request.userName() + " " + request.surname())
                .userRate(request.userRate())
                .build();
    }*/
}