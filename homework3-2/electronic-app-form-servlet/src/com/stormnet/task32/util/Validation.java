package com.stormnet.task32.util;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

public class Validation {

    private static final String MESSAGE = "<strong style=\"color: red\">Введены неверные данные</strong>";
    private static final String MIDDLE_NAME = "middle_name";
    private static final String AGE = "age";
    private static final String OTHER_COURSE = "other_course[]";
    private static final String SOURCES = "sources";
    private static final String OTHER_TEXT = "other_text";
    private static final String RECOMMENDATIONS = "recommendations";
    private LinkedList<String> paramForValidationFull;

    public LinkedList<String> getParamForValidationFull() {
        paramForValidationFull = new LinkedList<>();
        paramForValidationFull.addLast("last_name");
        paramForValidationFull.addLast("name");
        paramForValidationFull.addLast("middle_name");
        paramForValidationFull.addLast("password");
        paramForValidationFull.addLast("age");
        paramForValidationFull.addLast("sex");
        paramForValidationFull.addLast("course");
        paramForValidationFull.addLast("teacher");
        paramForValidationFull.addLast("grade");
        paramForValidationFull.addLast("other_course[]");
        paramForValidationFull.addLast("sources");
        paramForValidationFull.addLast("other_text");
        paramForValidationFull.addLast("recommendations");
        return paramForValidationFull;
    }

    private List<String> paramForValidation = new ArrayList<>();

    {
        paramForValidation.add("last_name");
        paramForValidation.add("name");
        paramForValidation.add("password");
        paramForValidation.add("sex");
        paramForValidation.add("course");
        paramForValidation.add("teacher");
        paramForValidation.add("grade");
    }

    private Map<String, String> errorsMap = new HashMap<>();


    public String getValidationError(String errorCode) {
        String errorMessage = errorsMap.get(errorCode);
        if (errorMessage == null) {
            errorMessage = "";
        }

        return errorMessage;
    }

    private boolean isEmpty(String value) {
        if (value == null) {
            return true;
        }

        return value.trim().equals("");
    }

    private boolean isNotEmpty(String value) {
        return !isEmpty(value);
    }

    public boolean isInvalidation(HttpServletRequest request) {
        Map<String, String[]> parameterMap = request.getParameterMap();

        for (String param : paramForValidation) {
            if (parameterMap.containsKey(param)) {
                String paramValue = parameterMap.get(param)[0];
                if (isEmpty(paramValue)) {
                    errorsMap.put(param, MESSAGE);
                    continue;
                }
                request.setAttribute(param, paramValue);
            } else {
                errorsMap.put(param, MESSAGE);
            }
        }

        if (parameterMap.containsKey(MIDDLE_NAME)) {
            String middleNameValue = parameterMap.get(MIDDLE_NAME)[0];
            if (isNotEmpty(middleNameValue)) {
                request.setAttribute(MIDDLE_NAME, middleNameValue);
            }
        }

        if (parameterMap.containsKey(AGE)) {
            String ageValue = parameterMap.get(AGE)[0].trim();
            if (isNotEmpty(ageValue)) {
                if (ageValue.matches("[-+]?\\d+")) {
                    request.setAttribute(AGE, ageValue);
                } else {
                    errorsMap.put(AGE, MESSAGE);
                }
            }
        }

        if (parameterMap.containsKey(OTHER_COURSE)) {
            request.setAttribute(OTHER_COURSE, parameterMap.get(OTHER_COURSE));
        }

        if (parameterMap.containsKey(SOURCES)) {
            request.setAttribute(SOURCES, parameterMap.get(SOURCES));
        } else {
            errorsMap.put(SOURCES, MESSAGE);
        }

        if (parameterMap.containsKey(OTHER_TEXT)) {
            String otherTextValue = parameterMap.get(OTHER_TEXT)[0];
            if (isEmpty(otherTextValue)) {
                errorsMap.put(OTHER_TEXT, MESSAGE);
            } else {
                request.setAttribute(OTHER_TEXT, otherTextValue);
            }
        }

        if (parameterMap.containsKey(RECOMMENDATIONS)) {
            String recommendationsValue = parameterMap.get(RECOMMENDATIONS)[0];
            if (isNotEmpty(recommendationsValue)) {
                request.setAttribute(RECOMMENDATIONS, recommendationsValue);
            }
        }

        return !errorsMap.isEmpty();
    }
}
