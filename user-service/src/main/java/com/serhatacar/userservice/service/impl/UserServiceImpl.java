package com.serhatacar.userservice.service.impl;

import com.serhatacar.userservice.dto.request.UserSaveRequest;
import com.serhatacar.userservice.dto.request.UserUpdateRequest;
import com.serhatacar.userservice.dto.response.UserDTO;
import com.serhatacar.userservice.entity.User;
import com.serhatacar.userservice.mapper.UserMapper;
import com.serhatacar.userservice.service.UserService;
import com.serhatacar.userservice.service.entityservice.UserEntityService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Serhat Acar
 */

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserEntityService userEntityService;
    private final UserMapper userMapper;

    @Override
    public List<UserDTO> getAllUsers() {
        return userMapper.convertToUserDTOList(userEntityService.findAll());
    }

    @Override
    public UserDTO getUserById(Long id) {
        return userMapper.convertToUserDTO(userEntityService.findByIdWithControl(id));
    }

    @Override
    public UserDTO saveUser(UserSaveRequest request) {
        return userMapper.convertToUserDTO(userEntityService.save(userMapper.convertToUser(request)));
    }

    @Override
    public UserDTO updateUser(UserUpdateRequest request) {
        User user = userEntityService.findByIdWithControl(request.id());
        userMapper.updateUserFields(user, request);
        userEntityService.save(user);
        return userMapper.convertToUserDTO(user);
    }

    @Override
    public void deleteUser(Long id) {
        User user = userEntityService.findByIdWithControl(id);
        userEntityService.delete(user);

    }
}
