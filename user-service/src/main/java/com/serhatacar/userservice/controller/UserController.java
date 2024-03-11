package com.serhatacar.userservice.controller;

import com.serhatacar.userservice.common.base.RestResponse;
import com.serhatacar.userservice.dto.request.UserSaveRequest;
import com.serhatacar.userservice.dto.request.UserUpdateRequest;
import com.serhatacar.userservice.dto.response.UserDTO;
import com.serhatacar.userservice.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Serhat Acar
 */

@RestController
@RequestMapping("api/v1/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @Operation(summary = "GET request for all users", description = "Returns all users in database<br>Accessible to admin users only.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Success"),
            @ApiResponse(responseCode = "401", description = "Unauthorized<br>-Token invalid (wrong or expired token)"),
            @ApiResponse(responseCode = "500", description = "Internal Server Error")
    })
    @GetMapping
    public ResponseEntity<RestResponse<List<UserDTO>>> getAllUsers() {
        List<UserDTO> allUsers = userService.getAllUsers();
        return ResponseEntity.ok(RestResponse.of(allUsers, "All users listed."));
    }

    @Operation(summary = "GET request for a user by id", description = "Returns a user by id<br>Accessible to admin users only.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Success"),
            @ApiResponse(responseCode = "401", description = "Unauthorized<br>-Token invalid (wrong or expired token)"),
            @ApiResponse(responseCode = "404", description = "Not Found<br>-User not found"),
            @ApiResponse(responseCode = "500", description = "Internal Server Error")
    })
    @GetMapping("/{id}")
    public ResponseEntity<RestResponse<UserDTO>> getUserById(@PathVariable Long id) {
        UserDTO userDTO = userService.getUserById(id);
        return ResponseEntity.ok(RestResponse.of(userDTO, "User listed."));
    }

    @Operation(summary = "POST request to save a user", description = "Saves a user to database<br>Accessible to admin users only.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Success"),
            @ApiResponse(responseCode = "400", description = "Bad Request<br>- E-mail already exists"),
            @ApiResponse(responseCode = "401", description = "Unauthorized<br>-Token invalid (wrong or expired token)"),
            @ApiResponse(responseCode = "500", description = "Internal Server Error")
    })
    @PostMapping
    public ResponseEntity<RestResponse<UserDTO>> saveUser(@RequestBody UserSaveRequest user) {
        UserDTO userDTO = userService.saveUser(user);
        return ResponseEntity.ok(RestResponse.of(userDTO, "User saved."));
    }

    @Operation(summary = "PUT request to update a user", description = "Updates a user in database<br>Accessible to admin users only.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Success"),
            @ApiResponse(responseCode = "401", description = "Unauthorized<br>-Token invalid (wrong or expired token)"),
            @ApiResponse(responseCode = "404", description = "Not Found<br>-User not found"),
            @ApiResponse(responseCode = "500", description = "Internal Server Error")
    })
    @PutMapping("/{debugId}")
    public ResponseEntity<RestResponse<UserDTO>> updateUser(@PathVariable Long debugId, @RequestBody UserUpdateRequest user) {
        UserDTO userDTO = userService.updateUser(user);
        return ResponseEntity.ok(RestResponse.of(userDTO, "User updated."));
    }

    @Operation(summary = "DELETE request to delete a user", description = "Deletes a user from database<br>Accessible to admin users only.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Success"),
            @ApiResponse(responseCode = "401", description = "Unauthorized<br>-Token invalid (wrong or expired token)"),
            @ApiResponse(responseCode = "404", description = "Not Found<br>-User not found"),
            @ApiResponse(responseCode = "500", description = "Internal Server Error")
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<RestResponse<UserDTO>> deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return ResponseEntity.ok(RestResponse.empty("User deleted."));
    }
}
