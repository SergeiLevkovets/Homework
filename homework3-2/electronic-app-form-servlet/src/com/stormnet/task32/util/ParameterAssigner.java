package com.stormnet.task32.util;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;
import java.util.LinkedHashMap;
import java.util.Map;

public class ParameterAssigner {

    private static final String LAST_NAME = "last_name";
    private static final String NAME = "name";
    private static final String MIDDLE_NAME = "middle_name";
    private static final String PASSWORD = "password";
    private static final String AGE = "age";
    private static final String SEX = "sex";
    private static final String COURSE = "course";
    private static final String TEACHER = "teacher";
    private static final String GRADE = "grade";
    private static final String OTHER_COURSE = "other_course[]";
    private static final String SOURCES = "sources";
    private static final String OTHER_TEXT = "other_text";
    private static final String RECOMMENDATIONS = "recommendations";

    private Map<String, String> parameterMap = new LinkedHashMap<>();

    private String setValueForMap(String value) {
        return "value=\"" + value + "\"";
    }

    public String getParameterValue(String parameterName) {
        String parameterValue = parameterMap.get(parameterName);
        if (parameterValue == null) {

            if (parameterName.equals("other_text_disabled")) {
                return "disabled";
            }

            return "";
        }

        return parameterValue;
    }

    public void setParameterForParameterMap(HttpServletRequest request) {
        Enumeration<String> attributeNames = request.getAttributeNames();
        while (attributeNames.hasMoreElements()) {
            String parameterName = attributeNames.nextElement();
            switch (parameterName) {
                case LAST_NAME:
                case NAME:
                case MIDDLE_NAME:
                case PASSWORD:
                case AGE: {
                    String value = (String) request.getAttribute(parameterName);
                    parameterMap.put(parameterName, setValueForMap(value));
                    break;
                }
                case OTHER_TEXT:
                case RECOMMENDATIONS: {
                    String value = (String) request.getAttribute(parameterName);
                    parameterMap.put(parameterName, value);
                    break;
                }
                case SEX: {
                    String sex = (String) request.getAttribute(SEX);
                    parameterMap.put("sex_" + sex, "checked");
                    break;
                }
                case COURSE: {
                    String course = (String) request.getAttribute(COURSE);
                    parameterMap.put("otherCourseDis_" + course, "disabled");
                    parameterMap.put("course_" + course, "selected");
                    break;
                }
                case TEACHER: {
                    String name = (String) request.getAttribute(TEACHER);
                    parameterMap.put("teacher_" + name, "selected");
                    break;
                }
                case GRADE: {
                    String grade = (String) request.getAttribute(GRADE);
                    parameterMap.put("grade_" + grade, "selected");
                    break;
                }
                case OTHER_COURSE: {
                    String[] values = (String[]) request.getAttribute(OTHER_COURSE);
                    for (String value : values) {
                        parameterMap.put("otherCourse_" + value, "selected");
                    }
                    break;
                }
                case SOURCES: {
                    String[] values = (String[]) request.getAttribute(SOURCES);
                    for (String value : values) {
                        if (value.equals("other")) {
                            parameterMap.put("other_text_disabled", "");
                        }
                        parameterMap.put(value, "checked");
                    }
                    break;
                }

            }

        }
    }

}
