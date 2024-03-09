package com.serhatacar.restaurantservice.controller;

import com.serhatacar.restaurantservice.common.base.RestResponse;
import com.serhatacar.restaurantservice.dto.request.RestaurantSaveRequest;
import com.serhatacar.restaurantservice.dto.request.RestaurantUpdateRequest;
import com.serhatacar.restaurantservice.dto.response.RestaurantDTO;
import com.serhatacar.restaurantservice.service.RestaurantService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Serhat Acar
 */
@RestController
@RequestMapping("/api/v1/restaurant")
@RequiredArgsConstructor
public class RestaurantController {

    private final RestaurantService restaurantService;

    @GetMapping
    public ResponseEntity<RestResponse<List<RestaurantDTO>>> getAllRestaurants() {
        return ResponseEntity.ok(RestResponse.of(restaurantService.getAllRestaurants(), "Restaurants are fetched successfully"));
    }

    @GetMapping("/{id}")
    public ResponseEntity<RestResponse<RestaurantDTO>> getRestaurantById(@PathVariable Long id) {
        return ResponseEntity.ok(RestResponse.of(restaurantService.getRestaurantById(id), "Restaurant is fetched successfully"));
    }

    @PostMapping
    public ResponseEntity<RestResponse<RestaurantDTO>> saveRestaurant(@RequestBody RestaurantSaveRequest request) {
        return ResponseEntity.ok(RestResponse.of(restaurantService.saveRestaurant(request), "Restaurant is saved successfully"));
    }

    @PutMapping
    public ResponseEntity<RestResponse<RestaurantDTO>> updateRestaurant(@RequestBody RestaurantUpdateRequest request) {
        return ResponseEntity.ok(RestResponse.of(restaurantService.updateRestaurant(request), "Restaurant is updated successfully"));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<RestResponse<Void>> deleteRestaurant(@PathVariable Long id) {
        restaurantService.deleteRestaurant(id);
        return ResponseEntity.ok(RestResponse.empty( "Restaurant is deleted successfully"));
    }
}
