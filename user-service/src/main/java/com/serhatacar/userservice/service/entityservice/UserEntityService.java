package com.serhatacar.userservice.service.entityservice;

import com.serhatacar.userservice.common.error.GeneralErrorMessage;
import com.serhatacar.userservice.entity.User;
import com.serhatacar.userservice.exception.notfound.UserNotFoundException;
import com.serhatacar.userservice.repository.UserRepository;
import org.springframework.stereotype.Service;

/**
 * @author Serhat Acar
 */
@Service
public class UserEntityService extends BaseEntityService<User, UserRepository>{
    protected UserEntityService(UserRepository repository) {
        super(repository);
    }

    @Override
    public User findByIdWithControl(Long id) {
        return getRepository().findById(id).orElseThrow(() -> new UserNotFoundException(GeneralErrorMessage.USER_NOT_FOUND));
    }
}
