package com.serhatacar.restaurantservice.common.error;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

/**
 * @author Serhat Acar
 */
@AllArgsConstructor
@Getter
@ToString
public enum GeneralErrorMessage implements BaseErrorMessage{

    ITEM_NOT_FOUND("Item not found"),
    RESTAURANT_NOT_FOUND("Restaurant not found"),
    RESTAURANT_NOT_ACTIVE("Restaurant not active"),
    RECOMMENDATION_NOT_FOUND("Recommendation not found");

    private final String errorMessage;

}
