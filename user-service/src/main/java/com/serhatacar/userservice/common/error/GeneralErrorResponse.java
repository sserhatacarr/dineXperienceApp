package com.serhatacar.userservice.common.error;

import java.time.LocalDateTime;

/**
 * @author Serhat Acar
 */

public record GeneralErrorResponse(
                                                LocalDateTime date,
                                                String errorMessage,
                                                String errorDescription) {
}
