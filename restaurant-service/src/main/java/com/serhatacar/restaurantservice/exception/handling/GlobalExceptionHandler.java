package com.serhatacar.restaurantservice.exception.handling;

import com.serhatacar.restaurantservice.common.base.RestResponse;
import com.serhatacar.restaurantservice.common.error.GeneralErrorMessageResponse;
import com.serhatacar.restaurantservice.service.kafka.KafkaProducerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;

/**
 * @author Serhat Acar
 */

@ControllerAdvice
@RequiredArgsConstructor
public class GlobalExceptionHandler {

    private final KafkaProducerService kafkaService;

    @ExceptionHandler(Exception.class)
    protected ResponseEntity<Object> handleException(Exception ex, WebRequest request) {
        String message = ex.getMessage();
        String description = request.getDescription(false);

        var generalErrorMessages = new GeneralErrorMessageResponse(LocalDateTime.now(), message, description);
        var restResponse = RestResponse.error(generalErrorMessages, message);

        kafkaService.sendMessage("errorLog", "message = " + message + " description = " + description);

        return ResponseEntity.badRequest().body(restResponse);
    }
}
