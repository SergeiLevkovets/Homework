package main;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Validation {

    private static final String MESSAGE = "Invalid data entered";
    private static List<String> paramForValidation = new ArrayList<>();

    static {
        paramForValidation.add("last_name");
        paramForValidation.add("name");
        paramForValidation.add("password");
        paramForValidation.add("age");
        paramForValidation.add("sex");
        paramForValidation.add("course");
        paramForValidation.add("teacher");
        paramForValidation.add("grade");
        paramForValidation.add("other_course[]");
        paramForValidation.add("sources");
        paramForValidation.add("other_text");
    }

    public static Map<String, String[]> validationMap(HttpServletRequest request) {
        Map<String, String[]> resultMap = new LinkedHashMap<>();
        Map<String, String[]> parameterMap = request.getParameterMap();


        for (String paramName : parameterMap.keySet()) {

            String[] paramArr = parameterMap.get(paramName);
            String[] values = null;

            if (paramForValidation.contains(paramName)) {

                if (paramName.equals("age")) {
                    for (int i = 0; i < paramArr.length; i++) {
                        if (isEmpty(paramArr[i])) {
                            continue;
                        }
                        if (!paramArr[i].matches("[-+]?\\d+")) {
                            paramArr[i] = MESSAGE;
                        }
                        values = paramArr;
                    }
                    if (values == null) {
                        continue;
                    }
                    resultMap.put(paramName, values);
                    continue;
                }
                for (int i = 0; i < paramArr.length; i++) {
                    if (isEmpty(paramArr[i])) {
                        paramArr[i] = MESSAGE;
                    }
                }
                resultMap.put(paramName, paramArr);

            } else {
                for (int i = 0; i < paramArr.length; i++) {
                    if (isEmpty(paramArr[i])) {
                        continue;
                    }
                    values = paramArr;
                }
                if (values == null) {
                    continue;
                }
                resultMap.put(paramName, values);
            }
        }

        return resultMap;

    }

    private static boolean isEmpty(String value) {
        return value.trim() == "";
    }


}
