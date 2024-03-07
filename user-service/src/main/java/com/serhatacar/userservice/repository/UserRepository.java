package com.serhatacar.userservice.repository;

import com.serhatacar.userservice.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Serhat Acar
 */

public interface UserRepository extends JpaRepository<User, Long> {
}
