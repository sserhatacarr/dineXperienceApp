package com.serhatacarr.loggingservice.service;

import com.serhatacarr.loggingservice.entity.ErrorLog;
import com.serhatacarr.loggingservice.repository.ErrorLogRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ErrorLogService {

    private final ErrorLogRepository errorLogRepository;

    public List<ErrorLog> findAll() {
        return errorLogRepository.findAll();
    }
}
