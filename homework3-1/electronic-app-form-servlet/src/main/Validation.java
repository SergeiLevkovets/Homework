package main;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Validation {

    private static final String MESSAGE = "<strong style=\"color: red\">Введены неверные данные</strong>";
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

    private static void otherTextValidation(Map<String, String[]> parameterMap) {

    }

    private static boolean isEmpty(String value) {
        return value.trim() == "";
    }

    public static Map<String, String[]> validationMap(HttpServletRequest request) {
        Map<String, String[]> resultMap = new LinkedHashMap<>();
        Map<String, String[]> parameterMap = request.getParameterMap();

        for (String param : paramForValidation) {
            if (parameterMap.keySet().contains(param)) {
                if (parameterMap.get(param).length == 1) {
                    if (isEmpty(parameterMap.get(param)[0])) {
                        resultMap.put(param, new String[]{MESSAGE});
                        continue;
                    }
                }
                resultMap.put(param, parameterMap.get(param));
            } else {
                resultMap.put(param, new String[]{MESSAGE});
            }
        }

        if (parameterMap.keySet().contains("middle_name")) {
            if (parameterMap.get("middle_name")[0].trim() != "") {
                resultMap.put("middle_name", parameterMap.get("recommendations"));
            }
        }

        if (parameterMap.keySet().contains("age")) {
            if (parameterMap.get("age")[0].trim() != "") {
                if (parameterMap.get("age")[0].matches("[-+]?\\d+")) {
                    resultMap.put("age", parameterMap.get("age"));
                } else {
                    resultMap.put("age", new String[]{MESSAGE});
                }
            }
        }


        if (parameterMap.keySet().contains("other_text") ) {
            if (isEmpty(parameterMap.get("other_text")[0])) {
                resultMap.put("other_text", new String[]{MESSAGE});
            } else {
                resultMap.put("other_text", parameterMap.get("other_text"));
            }
        }

        if (parameterMap.keySet().contains("recommendations")) {
            if (parameterMap.get("recommendations")[0].trim() != "") {
                resultMap.put("recommendations", parameterMap.get("recommendations"));
            }
        }

        return resultMap;

    }


}
