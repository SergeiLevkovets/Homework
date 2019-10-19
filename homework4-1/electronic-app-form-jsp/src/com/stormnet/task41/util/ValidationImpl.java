package com.stormnet.task41.util;

import java.util.HashMap;
import java.util.Map;

public class ValidationImpl implements Validation {

    private static final String MESSAGE = "<strong style=\"color: red\">Введены неверные данные</strong>";

    private Map<String, String> errorsMap;
    private boolean isContainsSex = false;
    private boolean isContainsSources = false;

    @Override
    public Map<String, String> getErrorsMap() {
        return errorsMap;
    }

    @Override
    public boolean isValidate() {
        return errorsMap.isEmpty();
    }

    private boolean isEmpty(String value) {
        if (value == null) {
            return true;
        }
        return value.trim().equals("");
    }

    @Override
    public void validate(Map<String, String[]> parameterMap) {
        errorsMap = new HashMap<>();
        for (String parameterName : parameterMap.keySet()) {
            switch (parameterName) {
                case "last_name":
                case "name":
                case "password":
                case "course":
                case "teacher":
                case "grade":
                case "other_text": {
                    String value = parameterMap.get(parameterName)[0];
                    if (isEmpty(value)) {
                        errorsMap.put(parameterName, MESSAGE);
                    }
                    break;
                }
                case "age": {
                    String value = parameterMap.get(parameterName)[0];
                    if (!isEmpty(value)) {
                        if (!value.matches("[-+]?\\d+")) {
                            errorsMap.put(parameterName, MESSAGE);
                        }
                    }
                    break;
                }
                case "sex": {
                    isContainsSex = true;
                    break;
                }
                case "sources": {
                    isContainsSources = true;
                    break;
                }
            }
        }
        if (!isContainsSex) {
            errorsMap.put("sex", MESSAGE);
        }
        if (!isContainsSources) {
            errorsMap.put("sources", MESSAGE);
        }
    }
}
