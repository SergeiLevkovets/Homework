package com.stormnet.task31.util;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Validation {

    private static final String[] MESSAGE = new String[]{"<strong style=\"color: red\">Введены неверные данные</strong>"};
    private static final String MIDDLE_NAME = "middle_name";
    private static final String AGE = "age";
    private static final String OTHER_COURSE = "other_course[]";
    private static final String SOURCES = "sources";
    private static final String OTHER_TEXT = "other_text";
    private static final String RECOMMENDATIONS = "recommendations";

    private static List<String> paramForValidation = new ArrayList<>();

    static {
        paramForValidation.add("last_name");
        paramForValidation.add("name");
        paramForValidation.add("password");
        paramForValidation.add("sex");
        paramForValidation.add("course");
        paramForValidation.add("teacher");
        paramForValidation.add("grade");
    }

    private static boolean isEmpty(String value) {
        if (value == null) {
            return true;
        }

        return value.trim().equals("");
    }

    private static boolean isNotEmpty(String value) {
        return !isEmpty(value);
    }

    public static boolean isInvalidation(HttpServletRequest request) {
        Map<String, String[]> parameterMap = request.getParameterMap();
        boolean result = false;

        for (String param : paramForValidation) {
            if (parameterMap.containsKey(param)) {
                String paramValue = parameterMap.get(param)[0];
                if (isEmpty(paramValue)) {
                    request.setAttribute(param, MESSAGE);
                    result = true;
                    continue;
                }
                request.setAttribute(param, paramValue);
            } else {
                request.setAttribute(param, MESSAGE);
                result = true;
            }
        }

        if (parameterMap.containsKey(MIDDLE_NAME)) {
            String middleNameValue = parameterMap.get(MIDDLE_NAME)[0];
            if (isNotEmpty(middleNameValue)) {
                request.setAttribute(MIDDLE_NAME, middleNameValue);
            }
        }

        if (parameterMap.containsKey(AGE)) {
            String ageValue = parameterMap.get(AGE)[0];
            if (isNotEmpty(ageValue)) {
                if (ageValue.matches("[-+]?\\d+")) {
                    request.setAttribute(AGE, ageValue);
                } else {
                    request.setAttribute(AGE, MESSAGE);
                    result = true;
                }
            }
        }

        if (parameterMap.containsKey(OTHER_COURSE)){
            request.setAttribute(OTHER_COURSE, parameterMap.get(OTHER_COURSE));
        }else {
            request.setAttribute(OTHER_COURSE, MESSAGE);
            result = true;
        }

        if (parameterMap.containsKey(SOURCES)){
            request.setAttribute(SOURCES, parameterMap.get(SOURCES));
        }else {
            request.setAttribute(SOURCES, MESSAGE);
            result = true;
        }

        if (parameterMap.containsKey(OTHER_TEXT)) {
            String otherTextValue = parameterMap.get(OTHER_TEXT)[0];
            if (isEmpty(otherTextValue)) {
                request.setAttribute(OTHER_TEXT, MESSAGE);
                result = true;
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

        return result;
    }
}
