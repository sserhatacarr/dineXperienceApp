package com.serhatacarr.loggingservice.repository;

import com.serhatacarr.loggingservice.entity.ErrorLog;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Serhat Acar
 */

public interface ErrorLogRepository extends JpaRepository<ErrorLog, Long> {
}
