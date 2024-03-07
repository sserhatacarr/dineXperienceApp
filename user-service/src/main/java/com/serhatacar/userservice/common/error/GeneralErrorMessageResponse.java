package com.serhatacar.userservice.common.error;

import java.time.LocalDateTime;

/**
 * @author Serhat Acar
 */

public record GeneralErrorMessageResponse (
                                                LocalDateTime date,
                                                String errorMessage,
                                                String errorDescription) {
}
