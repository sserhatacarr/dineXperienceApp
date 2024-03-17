package com.serhatacarr.loggingservice.controller;

import com.serhatacarr.loggingservice.entity.ErrorLog;
import com.serhatacarr.loggingservice.service.ErrorLogService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/error-logs")
@RequiredArgsConstructor
public class ErrorLogController {

    private final ErrorLogService errorLogService;

    @GetMapping
    public List<ErrorLog> findAll() {
        return errorLogService.findAll();
    }
}
