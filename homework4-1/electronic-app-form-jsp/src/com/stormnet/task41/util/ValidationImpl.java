package com.stormnet.task41.util;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class ValidationImpl implements Validation {

    private static final String MESSAGE = "<strong style=\"color: red\">Введены неверные данные</strong>";
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

    private LinkedList<String> paramForValidationFull;

    //Для вывода результатов в result.jsp в заданном порядке
    @Override
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

    private boolean isEmpty(String value) {
        if (value == null) {
            return true;
        }

        return value.trim().equals("");
    }

    private boolean isNotEmpty(String value) {
        return !isEmpty(value);
    }

    @Override
    public void validate(Map<String, String[]> parameterMap) {
        resultMap = new HashMap<>();
        for (String parameterName : parameterMap.keySet()) {
            switch (parameterName) {
                case LAST_NAME:
                case NAME:
                case OTHER_TEXT:
                case PASSWORD: {
                    String value = parameterMap.get(parameterName)[0];
                    if (isEmpty(value)) {
                        resultMap.put(setErrorsMes(parameterName), MESSAGE);
                        break;
                    }
                    resultMap.put(parameterName, value);
                    break;
                }
                case MIDDLE_NAME:
                case RECOMMENDATIONS: {
                    String value = parameterMap.get(parameterName)[0];
                    if (isNotEmpty(value)) {
                        resultMap.put(parameterName, value);
                    }
                    break;
                }
                case AGE: {
                    String value = parameterMap.get(parameterName)[0];
                    if (isNotEmpty(value)) {
                        if (value.matches("[-+]?\\d+")) {
                            resultMap.put(parameterName, value);
                            break;
                        } else {
                            resultMap.put(setErrorsMes(AGE), MESSAGE);
                        }
                    }
                    break;
                }
                case SEX: {
                    isContainsSex = true;
                    String sex = parameterMap.get(parameterName)[0];
                    resultMap.put("sex_" + sex, "checked");
                    break;
                }
                case COURSE: {
                    String course = parameterMap.get(parameterName)[0];
                    if (isEmpty(course)) {
                        resultMap.put(setErrorsMes(COURSE), MESSAGE);
                        break;
                    }
                    resultMap.put("otherCourseDis_" + course, "disabled");
                    resultMap.put("course_" + course, "selected");
                    break;
                }
                case TEACHER: {
                    String name = parameterMap.get(parameterName)[0];
                    if (isEmpty(name)) {
                        resultMap.put(setErrorsMes(TEACHER), MESSAGE);
                        break;
                    }
                    resultMap.put("teacher_" + name, "selected");
                    break;
                }
                case GRADE: {
                    String grade = parameterMap.get(parameterName)[0];
                    if (isEmpty(grade)) {
                        resultMap.put(setErrorsMes(GRADE), MESSAGE);
                        break;
                    }
                    resultMap.put("grade_" + grade, "selected");
                    break;
                }
                case OTHER_COURSE: {
                    String[] values = parameterMap.get(parameterName);
                    for (String value : values) {
                        resultMap.put("otherCourse_" + value, "selected");
                    }
                    break;
                }
                case SOURCES: {
                    isContainsSources = true;
                    String[] values = parameterMap.get(parameterName);
                    for (String value : values) {
                        if (value.equals("other")) {
                            resultMap.put("other_text_disabled", "=\"false\"");
                        }
                        resultMap.put(value, "checked");
                    }
                    break;
                }
            }
        }
    }
}
