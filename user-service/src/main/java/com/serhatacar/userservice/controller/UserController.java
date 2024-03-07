package com.serhatacar.userservice.controller;

import com.serhatacar.userservice.common.base.RestResponse;
import com.serhatacar.userservice.dto.request.UserSaveRequest;
import com.serhatacar.userservice.dto.request.UserUpdateRequest;
import com.serhatacar.userservice.dto.response.UserDTO;
import com.serhatacar.userservice.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Serhat Acar
 */

@RestController
@RequestMapping("api/v1/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping
    public ResponseEntity<RestResponse<List<UserDTO>>> getAllUsers() {
        List<UserDTO> allUsers = userService.getAllUsers();
        return ResponseEntity.ok(RestResponse.of(allUsers, "All users listed."));
    }

    @GetMapping("/{id}")
    public ResponseEntity<RestResponse<UserDTO>> getUserById(@PathVariable Long id) {
        UserDTO userDTO = userService.getUserById(id);
        return ResponseEntity.ok(RestResponse.of(userDTO, "User listed."));
    }

    @PostMapping
    public ResponseEntity<RestResponse<UserDTO>> saveUser(@RequestBody UserSaveRequest user) {
        UserDTO userDTO = userService.saveUser(user);
        return ResponseEntity.ok(RestResponse.of(userDTO, "User saved."));
    }

    @PutMapping("/{debugId}")
    public ResponseEntity<RestResponse<UserDTO>> updateUser(@PathVariable Long debugId, @RequestBody UserUpdateRequest user) {
        UserDTO userDTO = userService.updateUser(user);
        return ResponseEntity.ok(RestResponse.of(userDTO, "User updated."));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<RestResponse<UserDTO>> deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return ResponseEntity.ok(RestResponse.empty("User deleted."));
    }
}
