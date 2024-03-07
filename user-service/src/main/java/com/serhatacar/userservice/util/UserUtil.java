package com.serhatacar.userservice.util;

import com.serhatacar.userservice.common.error.GeneralErrorMessage;
import com.serhatacar.userservice.entity.User;
import com.serhatacar.userservice.entity.enums.Status;
import com.serhatacar.userservice.exception.notactive.UserNotActiveException;

/**
 * @author Serhat Acar
 */

public class UserUtil {

        private UserUtil() {
        }

        public static void checkIfUserIsActive(User user) {
            if(user.getUserStatus() != Status.ACTIVE) {
                throw new UserNotActiveException(GeneralErrorMessage.USER_NOT_ACTIVE);
            }
        }
}
