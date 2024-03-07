package com.serhatacar.userservice.dto.request;

import com.serhatacar.userservice.entity.enums.Gender;
import com.serhatacar.userservice.entity.enums.Status;

import java.time.LocalDate;

/**
 * @author Serhat Acar
 */

public record UserSaveRequest (
                                String name,
                                String surname,
                                LocalDate birthDate,
                                String email,
                                Gender gender,
                                Status userStatus,
                                double latitude,
                                double longitude){

}
