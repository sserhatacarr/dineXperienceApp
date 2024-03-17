package com.serhatacarr.loggingservice.service;

import com.serhatacarr.loggingservice.entity.ErrorLog;
import com.serhatacarr.loggingservice.repository.ErrorLogRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

/**
 * @author Serhat Acar
 */

@Service
@Slf4j
@RequiredArgsConstructor
public class KafkaConsumerService {

    private final ErrorLogRepository errorLogRepository;

    @KafkaListener(topics = "errorLog", groupId = "log-consumer-group")
    public void consume(@Payload(required = false) String message) {
        try {
            if (message == null || message.isEmpty()) {
                log.warn("Received an empty message from Kafka");
                return;
            }
            ErrorLog errorLog = ErrorLog.builder()
                    .message(message)
                    .date(LocalDateTime.now())
                    .build();
            errorLogRepository.save(errorLog);
        } catch (Exception e) {
            log.error("Error processing message: " + message, e);
            throw e;
        }
    }
}