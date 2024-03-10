package com.serhatacar.userservice.controller;

import com.serhatacar.userservice.common.base.RestResponse;
import com.serhatacar.userservice.dto.request.UserSaveRequest;
import com.serhatacar.userservice.dto.request.UserUpdateRequest;
import com.serhatacar.userservice.dto.response.UserDTO;
import com.serhatacar.userservice.entity.enums.Gender;
import com.serhatacar.userservice.entity.enums.Status;
import com.serhatacar.userservice.service.UserService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

/**
 * @author Serhat Acar
 */
@ExtendWith(MockitoExtension.class)
class UserControllerTest {
    @Mock
    private UserService userService;

    @InjectMocks
    private UserController userController;

    @Test
    void testGetAllUsers() {
        // Arrange
        UserDTO user1 = new UserDTO(1L, "name1", "surname1", LocalDate.now(), "email1", Gender.MALE, Status.ACTIVE, 4.0, 5.0);
        UserDTO user2 = new UserDTO(2L, "name2", "surname2", LocalDate.now(), "email2", Gender.FEMALE, Status.ACTIVE, 4.0, 4.0);
        List<UserDTO> users = Arrays.asList(user1, user2);

        when(userService.getAllUsers()).thenReturn(users);

        // Act
        ResponseEntity<RestResponse<List<UserDTO>>> response = userController.getAllUsers();

        // Assert
        assertEquals(200, response.getStatusCodeValue());
        assertEquals(users.size(), response.getBody().getData().size());
    }

    @Test
    void testGetUserById() {
        // Arrange
        Long id = 1L;
        UserDTO user = new UserDTO(id, "name", "surname", LocalDate.now(), "email", Gender.MALE, Status.ACTIVE, 4.0, 5.0);

        when(userService.getUserById(id)).thenReturn(user);

        // Act
        ResponseEntity<RestResponse<UserDTO>> response = userController.getUserById(id);

        // Assert
        assertEquals(200, response.getStatusCodeValue());
        assertEquals(user, response.getBody().getData());
    }

    @Test
    void testSaveUser() {
        // Arrange
        UserSaveRequest request = new UserSaveRequest("name", "surname", LocalDate.now(), "email", Gender.MALE, Status.ACTIVE, 4.0, 5.0);
        UserDTO user = new UserDTO(1L, "name", "surname", LocalDate.now(), "email", Gender.MALE, Status.ACTIVE, 4.0, 5.0);

        when(userService.saveUser(request)).thenReturn(user);

        // Act
        ResponseEntity<RestResponse<UserDTO>> response = userController.saveUser(request);

        // Assert
        assertEquals(200, response.getStatusCodeValue());
        assertEquals(user, response.getBody().getData());
    }


    @Test
    void testUpdateUser() {
        // Arrange
        Long id = 1L;
        UserUpdateRequest request = new UserUpdateRequest(1L,"name", "surname", LocalDate.now(), "email", Gender.MALE, Status.ACTIVE, 4.0, 5.0);
        UserDTO user = new UserDTO(id, "name", "surname", LocalDate.now(), "email", Gender.MALE, Status.ACTIVE, 4.0, 5.0);

        when(userService.updateUser(request)).thenReturn(user);

        // Act
        ResponseEntity<RestResponse<UserDTO>> response = userController.updateUser(id, request);

        // Assert
        assertEquals(200, response.getStatusCodeValue());
        assertEquals(user, response.getBody().getData());
    }

    @Test
    void testDeleteUser() {
        // Arrange
        Long id = 1L;

        // Act
        ResponseEntity<RestResponse<UserDTO>> response = userController.deleteUser(id);

        // Assert
        assertEquals(200, response.getStatusCodeValue());
        assertEquals(null, response.getBody().getData());
    }
}

