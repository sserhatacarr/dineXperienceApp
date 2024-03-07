package com.serhatacar.restaurantservice.exception.handling;

import com.serhatacar.restaurantservice.common.base.BaseRestResponse;
import com.serhatacar.restaurantservice.common.error.GeneralErrorMessageResponse;
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
    @ExceptionHandler (Exception.class)
    protected ResponseEntity<Object> handleException (Exception ex, WebRequest request){
        String message = ex.getMessage();
        String descipton = request.getDescription(false);

        var generalErrorMessages = new GeneralErrorMessageResponse(LocalDateTime.now(), message, descipton);
        var restResponse = BaseRestResponse.error(generalErrorMessages, message);

        return ResponseEntity.badRequest().body(restResponse);
    }
}
