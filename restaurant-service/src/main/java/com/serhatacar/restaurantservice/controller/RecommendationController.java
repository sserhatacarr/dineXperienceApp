package com.serhatacar.restaurantservice.controller;

import com.serhatacar.restaurantservice.common.base.RestResponse;
import com.serhatacar.restaurantservice.dto.response.RecommendationDTO;
import com.serhatacar.restaurantservice.service.RecommendationService;
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
@RequestMapping("/api/v1/recommendations")
@RequiredArgsConstructor
public class RecommendationController {

    private final RecommendationService recommendationService;

    @GetMapping("/{userId}")
    public ResponseEntity<RestResponse<RecommendationDTO>> getRecommendationByUserId(@PathVariable Long userId) {
        return ResponseEntity.ok(RestResponse.of(recommendationService.getRecommendationByUserId(userId), "Recommendation is fetched successfully"));
    }
}
