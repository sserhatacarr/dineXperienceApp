package com.serhatacar.restaurantservice.repository;

import com.serhatacar.restaurantservice.entity.Recommendation;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Serhat Acar
 */

public interface RecommendationRepository extends JpaRepository<Recommendation, Long> {
}
