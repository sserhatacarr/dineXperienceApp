package com.serhatacar.userservice.service;

import com.serhatacar.userservice.dto.request.UserSaveRequest;
import com.serhatacar.userservice.dto.request.UserUpdateRequest;
import com.serhatacar.userservice.dto.response.UserDTO;

import java.util.List;

/**
 * @author Serhat Acar
 */

public interface UserService {

    List<UserDTO> getAllUsers();

    UserDTO getUserById(Long id);

    UserDTO saveUser(UserSaveRequest request);

    UserDTO updateUser(UserUpdateRequest request);

    void deleteUser(Long id);

}
