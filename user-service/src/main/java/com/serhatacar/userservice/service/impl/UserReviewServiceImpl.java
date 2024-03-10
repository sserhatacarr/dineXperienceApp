package com.serhatacar.userservice.service.impl;

import com.serhatacar.userservice.client.RestaurantClient;
import com.serhatacar.userservice.dto.request.UserReviewSaveRequest;
import com.serhatacar.userservice.dto.request.UserReviewUpdateRequest;
import com.serhatacar.userservice.dto.response.RestaurantDTO;
import com.serhatacar.userservice.dto.response.UserReviewDetailDTO;
import com.serhatacar.userservice.entity.User;
import com.serhatacar.userservice.entity.UserReview;
import com.serhatacar.userservice.service.UserReviewService;
import com.serhatacar.userservice.service.entityservice.UserEntityService;
import com.serhatacar.userservice.service.entityservice.UserReviewEntityService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Serhat Acar
 */
@Service
@RequiredArgsConstructor
public class UserReviewServiceImpl implements UserReviewService {

    private final UserReviewEntityService userReviewEntityService;
    private final UserEntityService userEntityService;
    private final RestaurantClient restaurantClient;
    @Override
    public UserReviewDetailDTO saveUserReview(UserReviewSaveRequest request) {
    return null;
    }

    @Override
    public UserReviewDetailDTO getUserReviewById(Long id) {
        return null;
    }

    @Override
    public List<UserReviewDetailDTO> getAllUserReviews() {
        return null;
    }

    @Override
    public List<UserReviewDetailDTO> getUserReviewsByUserId() {
        return null;
    }

    @Override
    public UserReviewDetailDTO getUserReviewsByRestaurantId(Long restaurantId) {
        return null;
    }

    @Override
    public UserReviewDetailDTO editUserReview(UserReviewUpdateRequest request) {
        return null;
    }
}
