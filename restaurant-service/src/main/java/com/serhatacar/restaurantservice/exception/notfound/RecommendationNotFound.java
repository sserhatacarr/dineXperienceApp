package com.serhatacar.restaurantservice.exception.notfound;

import com.serhatacar.restaurantservice.common.error.BaseErrorMessage;

/**
 * @author Serhat Acar
 */

public class RecommendationNotFound extends ItemNotFoundException{
    public RecommendationNotFound(BaseErrorMessage baseErrorMessage) {
        super(baseErrorMessage);
    }
}
