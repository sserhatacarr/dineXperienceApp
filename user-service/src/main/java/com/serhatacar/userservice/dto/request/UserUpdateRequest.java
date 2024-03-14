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
        @NotNull @Positive(message = "Id is mandatory and should be positive")
        Long id,
        @NotBlank(message = "Name is mandatory")
        String name,
        @NotBlank(message = "Surname is mandatory")
        String surname,
        @NotNull(message = "BirthDate is mandatory")
        LocalDate birthDate,
        @Email(message = "Email should be valid")
        String email,
        Gender gender,
        @NotNull(message = "UserStatus is mandatory")
        Status userStatus,
        @NotNull(message = "Latitude is mandatory")
        double latitude,
        @NotNull(message = "Longitude is mandatory")
        double longitude) {
}