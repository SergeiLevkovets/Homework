package com.stormnet.task41.util;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class ValidationImpl implements Validation {

    private static final String MESSAGE = "<strong style=\"color: red\">Введены неверные данные</strong>";
    private static final String LAST_NAME = "last_name";
    private static final String NAME = "name";
    private static final String PASSWORD = "password";
    private static final String AGE = "age";
    private static final String SEX = "sex";
    private static final String COURSE = "course";
    private static final String TEACHER = "teacher";
    private static final String GRADE = "grade";
    private static final String SOURCES = "sources";
    private static final String OTHER_TEXT = "other_text";

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
            resultMap.put(setErrorsMes(SEX), MESSAGE);
        }
        if (!isContainsSources) {
            resultMap.put(setErrorsMes(SOURCES), MESSAGE);
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
                case LAST_NAME:
                case NAME:
                case OTHER_TEXT:
                case COURSE:
                case TEACHER:
                case GRADE:
                case PASSWORD: {
                    String value = parameterMap.get(parameterName)[0];
                    if (isEmpty(value)) {
                        resultMap.put(setErrorsMes(parameterName), MESSAGE);
                        break;
                    }
                }
                case AGE: {
                    String value = parameterMap.get(parameterName)[0];
                    if (!isEmpty(value)) {
                        if (!value.matches("[-+]?\\d+")) {
                            resultMap.put(setErrorsMes(AGE), MESSAGE);
                        }
                    }
                    break;
                }
                case SEX: {
                    isContainsSex = true;
                }
                case SOURCES: {
                    isContainsSources = true;
                    break;
                }
            }
        }
    }
}
