package com.serhatacar.userservice.service;

import com.serhatacar.userservice.dto.request.UserSaveRequest;
import com.serhatacar.userservice.dto.request.UserUpdateRequest;
import com.serhatacar.userservice.dto.response.UserDTO;
import com.serhatacar.userservice.entity.User;
import com.serhatacar.userservice.entity.enums.Gender;
import com.serhatacar.userservice.entity.enums.Status;
import com.serhatacar.userservice.mapper.UserMapper;
import com.serhatacar.userservice.service.entityservice.UserEntityService;
import com.serhatacar.userservice.service.impl.UserServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class UserServiceImplTest {

    @InjectMocks
    private UserServiceImpl userService;

    @Mock
    private UserEntityService userEntityService;

    @Mock
    private UserMapper userMapper;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetAllUsers() {

        // Arrange
        User user = new User();
        UserDTO userDTO = new UserDTO(
                1L,
                "name",
                "surname",
                LocalDate.now(),
                "email",
                Gender.MALE,
                Status.ACTIVE,
                4.0,
                5.0
        );
        when(userEntityService.findAll()).thenReturn(Collections.singletonList(user));
        when(userMapper.convertToUserDTOList(Collections.singletonList(user))).thenReturn(Collections.singletonList(userDTO));

        // Act
        List<UserDTO> result = userService.getAllUsers();

        // Assert
        assertEquals(1, result.size());
        verify(userEntityService, times(1)).findAll();
        verify(userMapper, times(1)).convertToUserDTOList(Collections.singletonList(user));
    }

    @Test
    public void testGetUserById() {

        // Arrange
        Long id = 1L;
        User user = new User();
        UserDTO userDTO = new UserDTO(
                1L,
                "name",
                "surname",
                LocalDate.now(),
                "email",
                Gender.MALE,
                Status.ACTIVE,
                4.0,
                5.0);
        when(userEntityService.findByIdWithControl(id)).thenReturn(user);
        when(userMapper.convertToUserDTO(user)).thenReturn(userDTO);

        // Act
        UserDTO result = userService.getUserById(id);

        // Assert
        assertEquals(userDTO, result);
        verify(userEntityService, times(1)).findByIdWithControl(id);
        verify(userMapper, times(1)).convertToUserDTO(user);

    }

    @Test
    public void testSaveUser() {

        // Arrange
        User user = new User();
        UserSaveRequest userSaveRequest = new UserSaveRequest(
                "name",
                "surname",
                LocalDate.now(),
                "email",
                Gender.MALE,
                Status.ACTIVE,
                4.0,
                5.0);

        UserDTO userDTO = new UserDTO(
                1L,
                "name",
                "surname",
                LocalDate.now(),
                "email",
                Gender.MALE,
                Status.ACTIVE,
                4.0,
                5.0);

        when(userEntityService.save(user)).thenReturn(user);
        when(userMapper.convertToUser(userSaveRequest)).thenReturn(user);
        when(userMapper.convertToUserDTO(user)).thenReturn(userDTO);

        // Act

        UserDTO result = userService.saveUser(userSaveRequest);

        // Assert

        assertEquals(userDTO, result);
        verify(userEntityService, times(1)).save(user);
        verify(userMapper, times(1)).convertToUser(userSaveRequest);
        verify(userMapper, times(1)).convertToUserDTO(user);

    }

    @Test
    public void testUpdateUser() {

        // Arrange
        User user = new User();
        UserUpdateRequest userUpdateRequest = new UserUpdateRequest(
                1L,
                "name",
                "surname",
                LocalDate.now(),
                "email",
                Gender.MALE,
                Status.ACTIVE,
                4.0,
                5.0);

        when(userEntityService.findByIdWithControl(userUpdateRequest.id())).thenReturn(user);
        when(userEntityService.save(user)).thenReturn(user);
        when(userMapper.convertToUserDTO(user)).thenReturn(new UserDTO(
                1L,
                "name",
                "surname",
                LocalDate.now(),
                "email",
                Gender.MALE,
                Status.ACTIVE,
                4.0,
                5.0));

        // Act
        UserDTO result = userService.updateUser(userUpdateRequest);

        // Assert
        verify(userEntityService, times(1)).findByIdWithControl(userUpdateRequest.id());
        verify(userMapper, times(1)).updateUserFields(user, userUpdateRequest);
        verify(userEntityService, times(1)).save(user);
        verify(userMapper, times(1)).convertToUserDTO(user);
    }

    @Test
    public void testDeleteUser() {

        // Arrange
        Long id = 1L;
        User user = new User();
        when(userEntityService.findByIdWithControl(id)).thenReturn(user);

        // Act
        userService.deleteUser(id);

        // Assert
        verify(userEntityService, times(1)).findByIdWithControl(id);
        verify(userEntityService, times(1)).delete(user);
    }
}