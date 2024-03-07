package com.serhatacar.userservice.service.entityservice;

import com.serhatacar.userservice.entity.User;
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
}
