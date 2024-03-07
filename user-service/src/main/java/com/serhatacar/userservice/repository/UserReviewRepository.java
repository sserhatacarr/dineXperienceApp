package com.serhatacar.userservice.repository;

import com.serhatacar.userservice.entity.UserReview;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Serhat Acar
 */

public interface UserReviewRepository extends JpaRepository<UserReview, Long> {
}
