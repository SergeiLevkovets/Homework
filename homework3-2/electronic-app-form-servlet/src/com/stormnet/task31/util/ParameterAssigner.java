package com.stormnet.task31.util;

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

    {
        parameterMap.put("last_name", "");
        parameterMap.put("name", "");
        parameterMap.put("middle_name", "");
        parameterMap.put("password", "");
        parameterMap.put("age", "");
        parameterMap.put("sex_men", "");
        parameterMap.put("sex_women", "");
        parameterMap.put("course_java_se", "");
        parameterMap.put("course_java_ee", "");
        parameterMap.put("course_python", "");
        parameterMap.put("course_html_css", "");
        parameterMap.put("course_javascript", "");
        parameterMap.put("course_php_sql", "");
        parameterMap.put("course_tester", "");
        parameterMap.put("teacher_ivanov", "");
        parameterMap.put("teacher_petrov", "");
        parameterMap.put("teacher_sidorov", "");
        parameterMap.put("grade_one", "");
        parameterMap.put("grade_two", "");
        parameterMap.put("grade_three", "");
        parameterMap.put("grade_four", "");
        parameterMap.put("grade_five", "");
        parameterMap.put("otherCourse_java_se", "");
        parameterMap.put("otherCourse_java_ee", "");
        parameterMap.put("otherCourse_python", "");
        parameterMap.put("otherCourse_html_css", "");
        parameterMap.put("otherCourse_javascript", "");
        parameterMap.put("otherCourse_php_sql", "");
        parameterMap.put("otherCourseDis_tester", "");
        parameterMap.put("otherCourseDis_java_se", "");
        parameterMap.put("otherCourseDis_java_ee", "");
        parameterMap.put("otherCourseDis_python", "");
        parameterMap.put("otherCourseDis_html_css", "");
        parameterMap.put("otherCourseDis_javascript", "");
        parameterMap.put("otherCourseDis_php_sql", "");
        parameterMap.put("otherCourseDis_tester", "");
        parameterMap.put("tv", "");
        parameterMap.put("radio", "");
        parameterMap.put("inet", "");
        parameterMap.put("metro", "");
        parameterMap.put("friends", "");
        parameterMap.put("other", "");
        parameterMap.put("other_text", "");
        parameterMap.put("other_text_disabled", "disabled");
        parameterMap.put("recommendations", "");
    }

    private String setValueForMap(String value) {
        if (value == null) {
            return "value=\"\"";
        }
        return "value=\"" + value + "\"";
    }

    public void setParameterForParameterMap(HttpServletRequest request) {
        Enumeration<String> attributeNames = request.getAttributeNames();
        while (attributeNames.hasMoreElements()) {
            String parameterName = attributeNames.nextElement();
            switch (parameterName) {
                case LAST_NAME: {
                    String value = (String) request.getAttribute(LAST_NAME);
                    parameterMap.put(LAST_NAME, setValueForMap(value));
                    break;
                }
                case NAME: {
                    String value = (String) request.getAttribute(NAME);
                    parameterMap.put(NAME, setValueForMap(value));
                    break;
                }
                case MIDDLE_NAME: {
                    String value = (String) request.getAttribute(MIDDLE_NAME);
                    parameterMap.put(MIDDLE_NAME, setValueForMap(value));
                    break;
                }
                case PASSWORD: {
                    String value = (String) request.getAttribute(PASSWORD);
                    parameterMap.put(PASSWORD, setValueForMap(value));
                    break;
                }
                case AGE: {
                    String value = (String) request.getAttribute(AGE);
                    parameterMap.put(AGE, setValueForMap(value));
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
                case OTHER_TEXT: {
                    String value = (String) request.getAttribute(OTHER_TEXT);
                    parameterMap.put(OTHER_TEXT, setValueForMap(value));
                    break;
                }
                case RECOMMENDATIONS: {
                    String value = (String) request.getAttribute(RECOMMENDATIONS);
                    parameterMap.put(RECOMMENDATIONS, setValueForMap(value));
                    break;
                }
            }

        }
    }


    public Map<String, String> getParameterMap() {
        return parameterMap;
    }
}
