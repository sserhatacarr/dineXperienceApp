package com.serhatacar.restaurantservice.service;

import com.serhatacar.restaurantservice.dto.response.RecommendationDTO;

import java.util.List;

/**
 * @author Serhat Acar
 */

public interface RecommendationService {

    RecommendationDTO getRecommendation(Long id);

   List<RecommendationDTO>  getRecommendationByUserId(Long userId);

    List <RecommendationDTO> getAllRecommendations();

    void deleteRecommendation(Long id);

}
