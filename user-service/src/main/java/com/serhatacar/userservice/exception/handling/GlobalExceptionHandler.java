package com.serhatacar.userservice.exception.handling;

import com.serhatacar.userservice.common.base.RestResponse;
import com.serhatacar.userservice.common.error.GeneralErrorMessageResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;

/**
 * @author Serhat Acar
 */

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(Exception.class)
    protected ResponseEntity<Object> handleException(Exception ex, WebRequest request) {
        String message = ex.getMessage();
        String description = request.getDescription(false);

        var generalErrorMessages = new GeneralErrorMessageResponse(LocalDateTime.now(), message, description);
        var restResponse = RestResponse.error(generalErrorMessages, message);

        return ResponseEntity.badRequest().body(restResponse);
    }
}
