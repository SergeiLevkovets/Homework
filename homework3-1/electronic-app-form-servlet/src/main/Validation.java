package main;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Validation {

    private static final String[] MESSAGE = new String[]{"<strong style=\"color: red\">Введены неверные данные</strong>"};
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
        return value.trim().equals("");
    }

    private static boolean isNotEmpty(String value) {
        return !value.trim().equals("");
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

        if (parameterMap.containsKey("other_text")) {
            String otherTextValue = parameterMap.get("other_text")[0];
            if (isEmpty(otherTextValue)) {
                resultMap.put("other_text", MESSAGE);
            } else {
                resultMap.put("other_text", parameterMap.get("other_text"));
            }
        }

        if (parameterMap.containsKey("middle_name")) {
            String middleNameValue = parameterMap.get("middle_name")[0];
            if (isNotEmpty(middleNameValue)) {
                resultMap.put("middle_name", parameterMap.get("middle_name"));
            }
        }

        if (parameterMap.containsKey("age")) {
            String ageValue = parameterMap.get("age")[0];
            if (isNotEmpty(ageValue)) {
                if (ageValue.matches("[-+]?\\d+")) {
                    resultMap.put("age", parameterMap.get("age"));
                } else {
                    resultMap.put("age", MESSAGE);
                }
            }
        }

        if (parameterMap.containsKey("recommendations")) {
            String recommendationsValue = parameterMap.get("recommendations")[0];
            if (isNotEmpty(recommendationsValue)) {
                resultMap.put("recommendations", parameterMap.get("recommendations"));
            }
        }

        return resultMap;
    }
}
