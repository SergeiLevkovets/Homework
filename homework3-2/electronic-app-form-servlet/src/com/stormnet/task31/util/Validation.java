package com.stormnet.task31.util;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Validation {

    private static final String MESSAGE = "<strong style=\"color: red\">Введены неверные данные</strong>";
    private static final String MIDDLE_NAME = "middle_name";
    private static final String AGE = "age";
    private static final String OTHER_COURSE = "other_course[]";
    private static final String SOURCES = "sources";
    private static final String OTHER_TEXT = "other_text";
    private static final String RECOMMENDATIONS = "recommendations";

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
    {
        errorsMap.put("last_name", "");
        errorsMap.put("name", "");
        errorsMap.put("password", "");
        errorsMap.put("age", "");
        errorsMap.put("sex", "");
        errorsMap.put("course", "");
        errorsMap.put("teacher", "");
        errorsMap.put("grade", "");
        errorsMap.put("sources", "");
        errorsMap.put("other_text", "");
    }

    public Map<String, String> getErrorsMap() {
        return errorsMap;
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
        boolean result = false;
        Map<String, String[]> parameterMap = request.getParameterMap();

        for (String param : paramForValidation) {
            if (parameterMap.containsKey(param)) {
                String paramValue = parameterMap.get(param)[0];
                if (isEmpty(paramValue)) {
                    errorsMap.put(param, MESSAGE);
                    result = true;
                    continue;
                }
                request.setAttribute(param, paramValue);
            } else {
                errorsMap.put(param, MESSAGE);
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
            String ageValue = parameterMap.get(AGE)[0].trim();
            if (isNotEmpty(ageValue)) {
                if (ageValue.matches("[-+]?\\d+")) {
                    request.setAttribute(AGE, ageValue);
                } else {
                    errorsMap.put(AGE, MESSAGE);
                    result = true;
                }
            }
        }

        if (parameterMap.containsKey(OTHER_COURSE)){
            request.setAttribute(OTHER_COURSE, parameterMap.get(OTHER_COURSE));
        }

        if (parameterMap.containsKey(SOURCES)){
            request.setAttribute(SOURCES, parameterMap.get(SOURCES));
        }else {
            errorsMap.put(SOURCES, MESSAGE);
            result = true;
        }

        if (parameterMap.containsKey(OTHER_TEXT)) {
            String otherTextValue = parameterMap.get(OTHER_TEXT)[0];
            if (isEmpty(otherTextValue)) {
                errorsMap.put(OTHER_TEXT, MESSAGE);
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
