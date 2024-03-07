package com.serhatacar.restaurantservice.common.error;

import java.time.LocalDateTime;

/**
 * @author Serhat Acar
 */

public record GeneralErrorMessageResponse (
                                                LocalDateTime date,
                                                String errorMessage,
                                                String errorDescription) {
}
