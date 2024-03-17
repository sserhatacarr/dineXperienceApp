package com.serhatacar.userservice.exception.handling;

import com.serhatacar.userservice.common.base.RestResponse;
import com.serhatacar.userservice.common.error.GeneralErrorResponse;
import com.serhatacar.userservice.exception.N11BusinessException;
import com.serhatacar.userservice.exception.notactive.ItemNotActiveException;
import com.serhatacar.userservice.exception.notactive.UserNotActiveException;
import com.serhatacar.userservice.exception.notfound.UserNotFoundException;
import com.serhatacar.userservice.service.kafka.KafkaProducerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
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

        var generalErrorMessages = new GeneralErrorResponse(LocalDateTime.now(), message, description);
        var restResponse = RestResponse.error(generalErrorMessages, message);

        kafkaService.sendMessage("errorLog", "message = " + message + " description = " + description);

        return ResponseEntity.badRequest().body(restResponse);
    }


    @ExceptionHandler(N11BusinessException.class)
    protected ResponseEntity<Object> handleN11BusinessException(N11BusinessException ex, WebRequest request) {
        String message = ex.getMessage();
        String description = request.getDescription(false);

        var generalErrorMessages = new GeneralErrorResponse(LocalDateTime.now(), message, description);
        var restResponse = RestResponse.error(generalErrorMessages, message);

        kafkaService.sendMessage("errorLog", "message = " + message + " description = " + description);

        return ResponseEntity.badRequest().body(restResponse);
    }

    @ExceptionHandler(ItemNotActiveException.class)
    protected ResponseEntity<Object> handleItemNotActiveException(ItemNotActiveException ex, WebRequest request) {
        String message = ex.getMessage();
        String description = request.getDescription(false);

        var generalErrorMessages = new GeneralErrorResponse(LocalDateTime.now(), message, description);
        var restResponse = RestResponse.error(generalErrorMessages, message);

        kafkaService.sendMessage("errorLog", "message = " + message + " description = " + description);

        return new ResponseEntity<>(ex.getMessage(), HttpStatus.FORBIDDEN);
    }

    @ExceptionHandler(UserNotActiveException.class)
    protected ResponseEntity<Object> handleUserNotActiveException(UserNotActiveException ex, WebRequest request) {
        String message = ex.getMessage();
        String description = request.getDescription(false);

        var generalErrorMessages = new GeneralErrorResponse(LocalDateTime.now(), message, description);
        var restResponse = RestResponse.error(generalErrorMessages, message);

        kafkaService.sendMessage("errorLog", "message = " + message + " description = " + description);

        return new ResponseEntity<>(ex.getMessage(), HttpStatus.FORBIDDEN);
    }

    @ExceptionHandler(UserNotFoundException.class)
    protected ResponseEntity<Object> handleUserNotFoundException(UserNotFoundException ex, WebRequest request) {
        String message = ex.getMessage();
        String description = request.getDescription(false);

        var generalErrorMessages = new GeneralErrorResponse(LocalDateTime.now(), message, description);
        var restResponse = RestResponse.error(generalErrorMessages, message);

        kafkaService.sendMessage("errorLog", "message = " + message + " description = " + description);

        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }
}
