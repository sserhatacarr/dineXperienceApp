package com.serhatacarr.loggingservice.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

/**
 * @author Serhat Acar
 */
@Document(collection = "errorlogdoc")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ErrorLog {

    @Id
    private String id;
    private LocalDateTime date;
    private String message;
}
