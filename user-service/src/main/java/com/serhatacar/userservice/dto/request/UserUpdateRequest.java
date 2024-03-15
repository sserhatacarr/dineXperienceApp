package com.serhatacar.userservice.dto.request;

import com.serhatacar.userservice.entity.enums.Gender;
import com.serhatacar.userservice.entity.enums.Status;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.time.LocalDate;

/**
 * @author Serhat Acar
 */

public record UserUpdateRequest(
        Long id,
        String name,
        String surname,
        LocalDate birthDate,
        String email,
        Gender gender,
        Status userStatus,
        double latitude,
        double longitude) {
}