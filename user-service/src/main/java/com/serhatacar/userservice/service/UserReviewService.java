package com.serhatacar.userservice.service;

import com.serhatacar.userservice.dto.request.UserReviewSaveRequest;
import com.serhatacar.userservice.dto.request.UserReviewUpdateRequest;
import com.serhatacar.userservice.dto.response.UserReviewDetailDTO;

import java.util.List;

/**
 * @author Serhat Acar
 */

public interface UserReviewService {
    UserReviewDetailDTO saveUserReview(UserReviewSaveRequest request);

    UserReviewDetailDTO getUserReviewById(Long id);

    List<UserReviewDetailDTO> getAllUserReviews();

    List<UserReviewDetailDTO> getUserReviewsByUserId(Long userId);

    List<UserReviewDetailDTO> getUserReviewsByRestaurantId(String restaurantId);

    UserReviewDetailDTO editUserReview(UserReviewUpdateRequest request);

    void deleteUserReview(Long id);
}
