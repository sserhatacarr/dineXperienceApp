package com.serhatacar.userservice.service.impl;

import com.serhatacar.userservice.client.RestaurantClient;
import com.serhatacar.userservice.dto.request.UserReviewSaveRequest;
import com.serhatacar.userservice.dto.request.UserReviewUpdateRequest;
import com.serhatacar.userservice.dto.response.RestaurantDTO;
import com.serhatacar.userservice.dto.response.UserReviewDetailDTO;
import com.serhatacar.userservice.entity.UserReview;
import com.serhatacar.userservice.mapper.UserReviewMapper;
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
    private final UserReviewMapper userReviewMapper;

    @Override
    public UserReviewDetailDTO saveUserReview(UserReviewSaveRequest request) {

        RestaurantDTO restaurantDTO = restaurantClient.getRestaurantById(request.restaurantId()).getBody().getData();
        UserReview userReview = userReviewMapper.convertToUserReview(request);
        userEntityService.findByIdWithControl(request.user().getId());
        userReview = userReviewEntityService.save(userReview);
        return userReviewMapper.toUserReviewDetail(userReview, restaurantDTO);
    }

    @Override
    public UserReviewDetailDTO getUserReviewById(Long id) {

        UserReview userReview = userReviewEntityService.findByIdWithControl(id);
        RestaurantDTO restaurantDTO = restaurantClient.getRestaurantById(userReview.getRestaurantId()).getBody().getData();
        return userReviewMapper.toUserReviewDetail(userReview, restaurantDTO);
    }

    @Override
    public List<UserReviewDetailDTO> getAllUserReviews() {

        List<UserReview> userReviews = userReviewEntityService.findAll();
        List <RestaurantDTO> restaurantDTOs = restaurantClient.getAllRestaurants().getBody().getData();
        return userReviewMapper.toUserReviewDetailList(userReviews, restaurantDTOs);
    }

    @Override
    public List<UserReviewDetailDTO> getUserReviewsByUserId(Long userId) {

        List<UserReview> userReviews = userReviewEntityService.findByUserId(userId);
        List <RestaurantDTO> restaurantDTOs = restaurantClient.getAllRestaurants().getBody().getData();
        // TODO: Burada komle  restaurantları çekmek ne kadar mantıklı ? Sercana sor.
        return userReviewMapper.toUserReviewDetailList(userReviews, restaurantDTOs);

    }

    @Override
    public List<UserReviewDetailDTO> getUserReviewsByRestaurantId(Long restaurantId) {

        List<UserReview> userReviews = userReviewEntityService.findByRestaurantId(restaurantId);
        RestaurantDTO restaurantDTO = restaurantClient.getRestaurantById(restaurantId).getBody().getData();
        return userReviewMapper.toUserReviewDetailList(userReviews, List.of(restaurantDTO));
    }

    @Override
    public UserReviewDetailDTO editUserReview(UserReviewUpdateRequest request) {

            UserReview userReview = userReviewEntityService.findByIdWithControl(request.id());
            userReviewMapper.updateUserReviewFields(userReview, request);
            userReview = userReviewEntityService.save(userReview);
            RestaurantDTO restaurantDTO = restaurantClient.getRestaurantById(userReview.getRestaurantId()).getBody().getData();
            return userReviewMapper.toUserReviewDetail(userReview, restaurantDTO);
    }
}
