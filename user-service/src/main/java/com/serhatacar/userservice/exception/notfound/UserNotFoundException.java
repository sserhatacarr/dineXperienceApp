package com.serhatacar.userservice.exception.notfound;

import com.serhatacar.userservice.common.error.BaseErrorMessage;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author Serhat Acar
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class UserNotFoundException extends ItemNotFoundException{
    public UserNotFoundException(BaseErrorMessage baseErrorMessage) {
        super(baseErrorMessage);
    }
}
