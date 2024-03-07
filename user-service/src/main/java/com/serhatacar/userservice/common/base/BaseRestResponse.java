package com.serhatacar.userservice.common.base;

import java.time.LocalDateTime;

/**
 * @author Serhat Acar
 */

public class BaseRestResponse<T> {
    private T data;
    private LocalDateTime responseDate;
    private boolean isSuccess;
    private String message;

    public BaseRestResponse(T data, boolean isSuccess, String message) {
        this.data = data;
        this.responseDate = LocalDateTime.now();
        this.isSuccess = isSuccess;
        this.message = message;
    }

    public static <T> BaseRestResponse<T> of(T data, String message) {
        return new BaseRestResponse<>(data, true, message);
    }

    public static <T> BaseRestResponse<T> error(T data, String message) {
        return new BaseRestResponse<>(data, false, message);
    }

    public static <T> BaseRestResponse<T> empty() {
        return new BaseRestResponse<>(null, true, null);
    }
}
