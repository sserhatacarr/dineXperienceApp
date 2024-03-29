package com.serhatacar.userservice.common.base;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author Serhat Acar
 */
@Getter
@Setter
@NoArgsConstructor
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

    public <T> RestResponse(List<T> ts) {
    }

    public static <T> RestResponse<T> of(T data, String message) {
        return new RestResponse<>(data, true, message);
    }

    public static <T> RestResponse<T> error(T data, String message) {
        return new RestResponse<>(data, false, message);
    }

    public static <T> RestResponse<T> empty(String message) {
        return new RestResponse<>(null, true, message);
    }
}
