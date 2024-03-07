package com.serhatacar.restaurantservice.common.base;

import jakarta.persistence.Embedded;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Serhat Acar
 */
@MappedSuperclass
@Getter
@Setter
public abstract class BaseEntity implements BaseModel{
    @Embedded
    private BaseAdditionalFields baseAdditionalFields;
}
