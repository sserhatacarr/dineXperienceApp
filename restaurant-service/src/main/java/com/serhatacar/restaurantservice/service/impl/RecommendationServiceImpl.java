package com.serhatacar.restaurantservice.service.impl;

import com.serhatacar.restaurantservice.dto.response.RecommendationDTO;
import com.serhatacar.restaurantservice.service.RecommendationService;
import com.serhatacar.restaurantservice.service.entityservice.RecommendationEntityService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Serhat Acar
 */
@Service
@RequiredArgsConstructor

public class RecommendationServiceImpl  implements RecommendationService {

    private final RecommendationEntityService recommendationEntityService;
    @Override
    public RecommendationDTO getRecommendation(Long id) {
        return null;
    }

    @Override
    public List<RecommendationDTO> getRecommendationByUserId(Long userId) {
        return null;
    }

    @Override
    public List<RecommendationDTO> getAllRecommendations() {
        return null;
    }

    @Override
    public void deleteRecommendation(Long id) {
        // TODO document why this method is empty
    }
}
