package com.serhatacar.userservice.dto.request;

import com.serhatacar.userservice.entity.enums.Gender;
import com.serhatacar.userservice.entity.enums.Status;

/**
 * @author Serhat Acar
 */

public record UserUpdateRequest(
        Long id,
        String name,
        String surname,
        String email,
        Gender gender,
        Status userStatus,
        double latitude,
        double longitude) {
}
