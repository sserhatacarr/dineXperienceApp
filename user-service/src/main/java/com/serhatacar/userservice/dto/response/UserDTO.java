package com.serhatacar.userservice.dto.response;

import com.serhatacar.userservice.entity.enums.Status;
import com.serhatacar.userservice.entity.enums.Gender;

import java.time.LocalDate;

/**
 * @author Serhat Acar
 */

public record UserDTO(
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
