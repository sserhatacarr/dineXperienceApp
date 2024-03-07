package com.serhatacar.userservice.exception.notactive;

import com.serhatacar.userservice.common.error.BaseErrorMessage;
import com.serhatacar.userservice.exception.N11BusinessException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author Serhat Acar
 */
@ResponseStatus(HttpStatus.FORBIDDEN)
public class ItemNotActiveException extends N11BusinessException {
    public ItemNotActiveException(BaseErrorMessage baseErrorMessage) {
        super(baseErrorMessage);
    }
}
