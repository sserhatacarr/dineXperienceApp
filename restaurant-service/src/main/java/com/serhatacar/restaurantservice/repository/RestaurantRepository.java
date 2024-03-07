package com.serhatacar.restaurantservice.repository;

import com.serhatacar.restaurantservice.entity.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Serhat Acar
 */

public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {
}
