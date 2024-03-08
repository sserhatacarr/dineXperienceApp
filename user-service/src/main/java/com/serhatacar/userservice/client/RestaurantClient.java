package com.serhatacar.userservice.client;

import com.serhatacar.restaurantservice.common.base.RestResponse;
import com.serhatacar.restaurantservice.dto.response.RestaurantDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
 * @author Serhat Acar
 */

@FeignClient(name = "restaurant-service", url = "http://localhost:8080/api/v1")
public interface RestaurantClient {

    @GetMapping("/restaurant")
    ResponseEntity<RestResponse<List<RestaurantDTO>>> getAllRestaurants();

    @GetMapping ("/restaurant/{id)")
    ResponseEntity<RestResponse<RestaurantDTO>> getRestaurantById(@PathVariable Long id);

}
