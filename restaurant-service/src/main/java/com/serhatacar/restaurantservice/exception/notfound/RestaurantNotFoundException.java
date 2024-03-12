package com.serhatacar.restaurantservice.exception.notfound;

import com.serhatacar.restaurantservice.common.error.BaseErrorMessage;

/**
 * @author Serhat Acar
 */

public class RestaurantNotFoundException extends ItemNotFoundException{
    public RestaurantNotFoundException(BaseErrorMessage baseErrorMessage) {
        super(baseErrorMessage);
    }
}
