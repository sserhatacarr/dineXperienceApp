package com.serhatacar.restaurantservice.client;

import com.serhatacar.restaurantservice.common.base.RestResponse;
import com.serhatacar.restaurantservice.dto.response.UserDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author Serhat Acar
 */

@FeignClient(name = "USER-SERVICE",path = "/api/v1/users")
public interface UserClient {

    @GetMapping("/{id}")
    ResponseEntity<RestResponse<UserDTO>> getUserById(@PathVariable Long id);
}
