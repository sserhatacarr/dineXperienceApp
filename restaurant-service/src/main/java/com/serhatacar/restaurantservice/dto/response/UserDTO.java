package com.serhatacar.restaurantservice.dto.response;

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
