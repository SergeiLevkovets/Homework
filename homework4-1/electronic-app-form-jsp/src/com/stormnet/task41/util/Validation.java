package com.stormnet.task41.util;

import org.jetbrains.annotations.Contract;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

public class Validation {

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
    private boolean isInvalidate = false;

    public boolean isInvalidate() {
        return isInvalidate;
    }

    private String setErrorsMes(String param) {
        isInvalidate = true;
        return param + "_err";
    }

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


    public void validation(HttpServletRequest request) {
        Enumeration<String> parameterNames = request.getParameterNames();
        while (parameterNames.hasMoreElements()) {
            String parameterName = parameterNames.nextElement();
            switch (parameterName) {
                case LAST_NAME:
                case NAME:
                case OTHER_TEXT:
                case PASSWORD: {
                    String value = request.getParameter(parameterName);
                    if(isEmpty(value)) {
                        request.setAttribute(setErrorsMes(parameterName), MESSAGE);
                        break;
                    }
                    request.setAttribute(parameterName, value);
                    break;
                }
                case AGE: {
                    String value = request.getParameter(parameterName);
                    if (isNotEmpty(value)) {
                        if (value.matches("[-+]?\\d+")) {
                            request.setAttribute(parameterName, value);
                            break;
                        } else {
                            request.setAttribute(setErrorsMes(AGE), MESSAGE);
                        }
                    }
                    break;
                }
                case MIDDLE_NAME:
                case RECOMMENDATIONS: {
                    String value = request.getParameter(parameterName);
                    if (isNotEmpty(value)) {
                        request.setAttribute(parameterName, value);
                    }
                    break;
                }
                case SEX: {
                    String sex = request.getParameter(SEX);
                    request.setAttribute("sex_" + sex, "checked");
                    break;
                }
                case COURSE: {
                    String course = request.getParameter(COURSE);
                    if (isEmpty(course)){
                        request.setAttribute(setErrorsMes(COURSE), MESSAGE);
                        break;
                    }
                    request.setAttribute("otherCourseDis_" + course, "disabled");
                    request.setAttribute("course_" + course, "selected");
                    break;
                }
                case TEACHER: {
                    String name = request.getParameter(TEACHER);
                    if (isEmpty(name)){
                        request.setAttribute(setErrorsMes(TEACHER), MESSAGE);
                        break;
                    }
                    request.setAttribute("teacher_" + name, "selected");
                    break;
                }
                case GRADE: {
                    String grade = request.getParameter(GRADE);
                    if (isEmpty(grade)){
                        request.setAttribute(setErrorsMes(GRADE), MESSAGE);
                        break;
                    }
                    request.setAttribute("grade_" + grade, "selected");
                    break;
                }
                case OTHER_COURSE: {
                    String[] values = request.getParameterValues(OTHER_COURSE);
                    for (String value : values) {
                        request.setAttribute("otherCourse_" + value, "selected");
                    }
                    break;
                }
                case SOURCES: {
                    String[] values = request.getParameterValues(SOURCES);
                    for (String value : values) {
                        if (value.equals("other")) {
                            request.setAttribute("other_text_disabled", "=\"false\"");
                        }
                        request.setAttribute(value, "checked");
                    }
                    break;
                }
            }
        }
        String sex = request.getParameter(SEX);
        if (isEmpty(sex)){
            request.setAttribute(setErrorsMes(SEX), MESSAGE);
        }
        String sources = request.getParameter(SOURCES);
        if (isEmpty(sources)){
            request.setAttribute(setErrorsMes(SOURCES), MESSAGE);
        }

    }
}
