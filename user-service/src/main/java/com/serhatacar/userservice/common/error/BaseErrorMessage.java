package com.serhatacar.userservice.common.error;

import java.io.Serializable;

/**
 * @author Serhat Acar
 */

public interface BaseErrorMessage extends Serializable {


    String getErrorMessage();
}
