package com.serhatacar.userservice.repository;

import com.serhatacar.userservice.entity.UserReview;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author Serhat Acar
 */

public interface UserReviewRepository extends JpaRepository<UserReview, Long> {

    List<UserReview> findByUserId(Long userId);
    List<UserReview> findByRestaurantId(Long restaurantId);
}
