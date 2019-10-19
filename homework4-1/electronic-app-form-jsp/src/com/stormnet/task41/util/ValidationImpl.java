package com.stormnet.task41.util;

import java.util.HashMap;
import java.util.Map;

public class ValidationImpl implements Validation {

    private static final String MESSAGE = "<strong style=\"color: red\">Введены неверные данные</strong>";

    private Map<String, String> resultMap;
    private boolean isInvalidate = false;
    private boolean isContainsSex = false;
    private boolean isContainsSources = false;

    @Override
    public Map<String, String> getResultMap() {
        return resultMap;
    }

    @Override
    public boolean isInvalidate() {
        if (!isContainsSex) {
            resultMap.put(setErrorsMes("sex"), MESSAGE);
        }
        if (!isContainsSources) {
            resultMap.put(setErrorsMes("sources"), MESSAGE);
        }

        return isInvalidate;
    }

    private String setErrorsMes(String param) {
        isInvalidate = true;
        return param + "_err";
    }

    private boolean isEmpty(String value) {
        if (value == null) {
            return true;
        }
        return value.trim().equals("");
    }

    @Override
    public void validate(Map<String, String[]> parameterMap) {
        resultMap = new HashMap<>();
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
                        resultMap.put(setErrorsMes(parameterName), MESSAGE);
                        break;
                    }
                }
                case "age": {
                    String value = parameterMap.get(parameterName)[0];
                    if (!isEmpty(value)) {
                        if (!value.matches("[-+]?\\d+")) {
                            resultMap.put(setErrorsMes(parameterName), MESSAGE);
                        }
                    }
                    break;
                }
                case "sex": {
                    isContainsSex = true;
                }
                case "sources": {
                    isContainsSources = true;
                    break;
                }
            }
        }
    }
}
