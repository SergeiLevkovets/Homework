package com.stormnet.task31.util;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Validation {

    private static final String[] MESSAGE = new String[]{"<strong style=\"color: red\">Введены неверные данные</strong>"};
    private static final String OTHER_TEXT = "other_text";
    private static final String MIDDLE_NAME = "middle_name";
    private static final String AGE = "age";
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
        paramForValidation.add("other_course[]");
        paramForValidation.add("sources");
    }

    private static boolean isEmpty(String value) {
        if (value == null){
            return true;
        }

        return value.trim().equals("");
    }

    private static boolean isNotEmpty(String value) {
        return !isEmpty(value);
    }

    public static Map<String, String[]> validationMap(HttpServletRequest request) {
        Map<String, String[]> resultMap = new HashMap<>();
        Map<String, String[]> parameterMap = request.getParameterMap();

        for (String param : paramForValidation) {
            if (parameterMap.containsKey(param)) {
                if (parameterMap.get(param).length == 1) {
                    String paramValue = parameterMap.get(param)[0];
                    if (isEmpty(paramValue)) {
                        resultMap.put(param, MESSAGE);
                        continue;
                    }
                }
                resultMap.put(param, parameterMap.get(param));
            } else {
                resultMap.put(param, MESSAGE);
            }
        }

        if (parameterMap.containsKey(OTHER_TEXT)) {
            String otherTextValue = parameterMap.get(OTHER_TEXT)[0];
            if (isEmpty(otherTextValue)) {
                resultMap.put(OTHER_TEXT, MESSAGE);
            } else {
                resultMap.put(OTHER_TEXT, parameterMap.get(OTHER_TEXT));
            }
        }

        if (parameterMap.containsKey(MIDDLE_NAME)) {
            String middleNameValue = parameterMap.get(MIDDLE_NAME)[0];
            if (isNotEmpty(middleNameValue)) {
                resultMap.put(MIDDLE_NAME, parameterMap.get(MIDDLE_NAME));
            }
        }

        if (parameterMap.containsKey(AGE)) {
            String ageValue = parameterMap.get(AGE)[0];
            if (isNotEmpty(ageValue)) {
                if (ageValue.matches("[-+]?\\d+")) {
                    resultMap.put(AGE, parameterMap.get(AGE));
                } else {
                    resultMap.put(AGE, MESSAGE);
                }
            }
        }

        if (parameterMap.containsKey(RECOMMENDATIONS)) {
            String recommendationsValue = parameterMap.get(RECOMMENDATIONS)[0];
            if (isNotEmpty(recommendationsValue)) {
                resultMap.put(RECOMMENDATIONS, parameterMap.get(RECOMMENDATIONS));
            }
        }

        return resultMap;
    }
}
