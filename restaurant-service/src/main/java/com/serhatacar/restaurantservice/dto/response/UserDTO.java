package com.serhatacar.restaurantservice.dto.response;


import java.time.LocalDate;

/**
 * @author Serhat Acar
 */

public record UserDTO(
                      Long id,
                      String name,
                      String surname,
                      String email,
                      double latitude,
                      double longitude) {
}
