package com.serhatacarr.loggingservice.repository;

import com.serhatacarr.loggingservice.entity.ErrorLog;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @author Serhat Acar
 */

public interface ErrorLogRepository extends MongoRepository<ErrorLog, String> {
}
