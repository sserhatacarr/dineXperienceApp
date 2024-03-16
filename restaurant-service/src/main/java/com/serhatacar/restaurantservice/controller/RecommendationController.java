package com.serhatacar.restaurantservice.controller;

import com.serhatacar.restaurantservice.common.base.RestResponse;
import com.serhatacar.restaurantservice.dto.response.RecommendationDTO;
import com.serhatacar.restaurantservice.service.RecommendationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Serhat Acar
 */
@RestController
@RequestMapping("/api/v1/restaurants/recommendations")
@RequiredArgsConstructor
public class RecommendationController {

    private final RecommendationService recommendationService;

    @Operation(summary = "GET request for restaurant recommendations by user id", description = "Returns restaurant recommendations for a user by their ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Success"),
            @ApiResponse(responseCode = "404", description = "Not Found<br>-User not found"),
            @ApiResponse(responseCode = "500", description = "Internal Server Error")
    })
    @GetMapping("/{userId}")
    public ResponseEntity<RestResponse<RecommendationDTO>> getRecommendationByUserId(@PathVariable Long userId) {
        return ResponseEntity.ok(RestResponse.of(recommendationService.getRecommendationByUserId(userId), "Recommendation is fetched successfully"));
    }
}
