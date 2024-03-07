package com.serhatacar.userservice.exception.notactive;

import com.serhatacar.userservice.common.error.BaseErrorMessage;
import com.serhatacar.userservice.exception.N11BusinessException;

/**
 * @author Serhat Acar
 */

public class UserNotActiveException extends ItemNotActiveException {
    public UserNotActiveException(BaseErrorMessage baseErrorMessage) {
        super(baseErrorMessage);
    }
}
