package com.serhatacar.restaurantservice.common.base;

import java.time.LocalDateTime;

/**
 * @author Serhat Acar
 */

public class RestResponse<T> {
    private T data;
    private LocalDateTime responseDate;
    private boolean isSuccess;
    private String message;

    public RestResponse(T data, boolean isSuccess, String message) {
        this.data = data;
        this.responseDate = LocalDateTime.now();
        this.isSuccess = isSuccess;
        this.message = message;
    }

    public static <T> RestResponse<T> of(T data, String message) {
        return new RestResponse<>(data, true, message);
    }

    public static <T> RestResponse<T> error(T data, String message) {
        return new RestResponse<>(data, false, message);
    }

    public static <T> RestResponse<T> empty() {
        return new RestResponse<>(null, true, null);
    }
}
