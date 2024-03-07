package com.serhatacar.userservice.common;

import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

/**
 * @author Serhat Acar
 */
@Getter
@Setter
@Embeddable
public  class BaseAdditionalFields {
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private Long creatorId;
    private Long updatedId;

}

