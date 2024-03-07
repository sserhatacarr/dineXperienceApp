package com.serhatacar.userservice.common.error;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

/**
 * @author Serhat Acar
 */
@AllArgsConstructor
@Getter
@ToString
public enum GeneralErrorMessage implements BaseErrorMessage{

    ITEM_NOT_FOUND("Item not found"),
    USER_NOT_FOUND("User not found"),
    USER_NOT_ACTIVE("User not active"),
    USER_REVIEW_NOT_FOUND("User review not found");

    private final String errorMessage;

}
