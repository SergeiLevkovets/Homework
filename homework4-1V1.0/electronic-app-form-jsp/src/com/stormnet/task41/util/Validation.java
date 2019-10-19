package com.stormnet.task41.util;

import java.util.LinkedList;
import java.util.Map;

public interface Validation {

    Map<String, String> getResultMap();

    boolean isInvalidate();

    //Для вывода результатов в result.jsp в заданном порядке
    LinkedList<String> getParamForValidationFull();

    void validate(Map<String, String[]> parameterMap);
}
