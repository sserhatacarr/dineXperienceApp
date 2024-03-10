package com.serhatacar.userservice.client;


import com.serhatacar.userservice.common.base.RestResponse;
import com.serhatacar.userservice.dto.response.RestaurantDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
 * @author Serhat Acar
 */

@FeignClient(name = "restaurant-service", url = "http://localhost:8080/api/v1/restaurants")
public interface RestaurantClient {

    @GetMapping()
    ResponseEntity<RestResponse<List<RestaurantDTO>>> getAllRestaurants();


    @GetMapping ("/{id}")
    ResponseEntity<RestResponse<RestaurantDTO>> getRestaurantById(@PathVariable(name="id") Long id);


}
