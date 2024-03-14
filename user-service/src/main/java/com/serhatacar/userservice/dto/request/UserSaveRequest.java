package com.serhatacar.userservice.dto.request;

import com.serhatacar.userservice.entity.enums.Gender;
import com.serhatacar.userservice.entity.enums.Status;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDate;

/**
 * @author Serhat Acar
 */

public record UserSaveRequest (
        @NotBlank (message = "Name is mandatory")
        String name,
        @NotBlank (message = "Surname is mandatory")
        String surname,
        @NotBlank (message = "Password is mandatory")
        LocalDate birthDate,
        @Email( message = "Email should be valid")
        String email,
        Gender gender,
        @NotBlank (message = "Status is mandatory")
        Status userStatus,
        @NotBlank (message = "Latitude is mandatory")
        double latitude,
        @NotBlank (message = "Longitude is mandatory")
        double longitude){

}
