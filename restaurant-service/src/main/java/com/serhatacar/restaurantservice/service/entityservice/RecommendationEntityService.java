package com.serhatacar.restaurantservice.service.entityservice;

import com.serhatacar.restaurantservice.entity.Recommendation;
import com.serhatacar.restaurantservice.repository.RecommendationRepository;
import org.springframework.stereotype.Service;

/**
 * @author Serhat Acar
 */
@Service
public class RecommendationEntityService extends BaseEntityService<Recommendation, RecommendationRepository>{
    protected RecommendationEntityService(RecommendationRepository repository) {
        super(repository);
    }

    public Recommendation findByIdWithControl(Long id) {
        return getRepository().findById(id).orElse(null);
    }
}
