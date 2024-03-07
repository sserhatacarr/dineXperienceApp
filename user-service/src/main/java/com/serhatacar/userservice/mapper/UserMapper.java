package com.serhatacar.userservice.mapper;

import com.serhatacar.userservice.dto.request.UserSaveRequest;
import com.serhatacar.userservice.dto.request.UserUpdateRequest;
import com.serhatacar.userservice.dto.response.UserDTO;
import com.serhatacar.userservice.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.ReportingPolicy;

import java.util.List;

/**
 * @author Serhat Acar
 */
@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface UserMapper {

    User convertToUser (UserSaveRequest request);
    UserDTO convertToUserDTO(User user);

    @Mapping(target = "id", ignore = true)
    void updateUserFields(@MappingTarget User user, UserUpdateRequest request);

    List<UserDTO> convertToUserDTOList(List<User> userList);

}
