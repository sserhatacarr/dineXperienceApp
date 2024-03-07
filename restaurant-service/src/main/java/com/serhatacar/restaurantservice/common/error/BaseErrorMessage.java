package com.serhatacar.restaurantservice.common.error;

import java.io.Serializable;

/**
 * @author Serhat Acar
 */

public interface BaseErrorMessage extends Serializable {


    String getErrorMessage();
}
