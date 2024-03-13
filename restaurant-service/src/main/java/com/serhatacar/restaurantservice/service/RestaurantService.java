package com.serhatacar.restaurantservice.service;

import com.serhatacar.restaurantservice.dto.request.RestaurantSaveRequest;
import com.serhatacar.restaurantservice.dto.request.RestaurantUpdateRequest;
import com.serhatacar.restaurantservice.dto.response.RestaurantDTO;

/**
 * @author Serhat Acar
 */

public interface RestaurantService {
    RestaurantDTO saveRestaurant(RestaurantSaveRequest request);

    Iterable<RestaurantDTO> getAllRestaurants();

    RestaurantDTO getRestaurantById(Long id);

    RestaurantDTO updateRestaurant(RestaurantUpdateRequest request);

    void deleteRestaurant(Long id);
}
