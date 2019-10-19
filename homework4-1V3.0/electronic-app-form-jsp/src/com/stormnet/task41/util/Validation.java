package com.stormnet.task41.util;

import java.util.Map;

public interface Validation {

    Map<String, String> getErrorsMap();

    boolean isValidate();

    void validate(Map<String, String[]> parameterMap);
}
