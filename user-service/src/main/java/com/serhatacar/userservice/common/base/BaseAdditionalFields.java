package com.serhatacar.userservice.common.base;

import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.LastModifiedBy;

import java.time.LocalDateTime;

/**
 * @author Serhat Acar
 */
@Getter
@Setter
@Embeddable
public  class BaseAdditionalFields {
    @CreationTimestamp
    private LocalDateTime createdAt;
    @UpdateTimestamp
    private LocalDateTime updatedAt;
    @CreatedBy
    private Long creatorId;
    @LastModifiedBy
    private Long updatedId;

}

