package com.serhatacar.userservice.exception.notfound;

import com.serhatacar.userservice.common.error.BaseErrorMessage;
import com.serhatacar.userservice.exception.N11BusinessException;
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
