package com.serhatacar.restaurantservice.exception.notactive;

import com.serhatacar.restaurantservice.common.error.BaseErrorMessage;
import com.serhatacar.restaurantservice.exception.N11BusinessException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author Serhat Acar
 */

@ResponseStatus(HttpStatus.NOT_FOUND)

public class ItemNotFoundException extends N11BusinessException {

    public ItemNotFoundException(BaseErrorMessage baseErrorMessage) {
        super(baseErrorMessage);
    }



}
