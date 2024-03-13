package com.serhatacar.restaurantservice.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Serhat Acar
 */
@RestController
@RequestMapping("/api/v1/restaurants")
@RequiredArgsConstructor
public class RestaurantController {

    /*private final RestaurantService restaurantService;

     *//* @Operation(summary = "GET request for all restaurants", description = "Returns all restaurants in database<br>Accessible to admin users only.")
     @ApiResponses(value = {
             @ApiResponse(responseCode = "200", description = "Success"),
             @ApiResponse(responseCode = "500", description = "Internal Server Error")
     })
     @GetMapping
     public ResponseEntity<RestResponse<Iterable<RestaurantDTO>>> getAllRestaurants() {
         return ResponseEntity.ok(RestResponse.of(restaurantService.getAllRestaurants(), "Restaurants are fetched successfully"));
     }

     @Operation(summary = "GET request for restaurant by id", description = "Returns a restaurant by id <br>Accessible to admin users only.")
     @ApiResponses(value = {
             @ApiResponse(responseCode = "200", description = "Success"),
             @ApiResponse(responseCode = "404", description = "Not Found<br>-Restaurant not found"),
             @ApiResponse(responseCode = "500", description = "Internal Server Error")
     })*//*
    @GetMapping("/{id}")
    public ResponseEntity<RestResponse<RestaurantDTO>> getRestaurantById(@PathVariable Long id) {
        return ResponseEntity.ok(RestResponse.of(restaurantService.getRestaurantById(id), "Restaurant is fetched successfully"));
    }

    @Operation(summary = "POST request to save a restaurant", description = "Saves a restaurant to database<br>Accessible to admin users only.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Success"),
            @ApiResponse(responseCode = "400", description = "Bad Request<br>- E-mail already exists"),
            @ApiResponse(responseCode = "500", description = "Internal Server Error")
    })
    @PostMapping
    public ResponseEntity<RestResponse<RestaurantDTO>> saveRestaurant(@RequestBody RestaurantSaveRequest request) {
        return ResponseEntity.ok(RestResponse.of(restaurantService.saveRestaurant(request), "Restaurant is saved successfully"));
    }

    @Operation(summary = "PUT request to update a restaurant", description = "Updates a restaurant in database<br>Accessible to admin users only.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Success"),
            @ApiResponse(responseCode = "400", description = "Bad Request<br>- Restaurant not found"),
            @ApiResponse(responseCode = "500", description = "Internal Server Error")
    })
    @PutMapping
    public ResponseEntity<RestResponse<RestaurantDTO>> updateRestaurant(@RequestBody RestaurantUpdateRequest request) {
        return ResponseEntity.ok(RestResponse.of(restaurantService.updateRestaurant(request), "Restaurant is updated successfully"));
    }

    @Operation(summary = "DELETE request to delete a restaurant", description = "Deletes a restaurant from database<br>Accessible to admin users only.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Success"),
            @ApiResponse(responseCode = "400", description = "Bad Request<br>- Restaurant not found"),
            @ApiResponse(responseCode = "500", description = "Internal Server Error")
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<RestResponse<Void>> deleteRestaurant(@PathVariable Long id) {
        restaurantService.deleteRestaurant(id);
        return ResponseEntity.ok(RestResponse.empty("Restaurant is deleted successfully"));
    }*/
}
