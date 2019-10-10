package com.stormnet.task31.util;

import com.sun.deploy.net.HttpRequest;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
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
    private static final String TV = "tv";
    private static final String RADIO = "radio";
    private static final String INET = "inet";
    private static final String METRO = "metro";
    private static final String FRIENDS = "friends";
    private static final String OTHER = "other";
    private static final String OTHER_TEXT = "other_text";
    private static final String RECOMMENDATIONS = "recommendations";

    private Map<String, String> parameterMap = new HashMap<>();

    {
        parameterMap.put("lastName", "value=\"\"");
        parameterMap.put("name", "value=\"\"");
        parameterMap.put("middleName", "value=\"\"");
        parameterMap.put("password", "value=\"\"");
        parameterMap.put("age", "value=\"\"");
        parameterMap.put("sexMen", "");
        parameterMap.put("sexWomen", "");
        parameterMap.put("courseJavaSE", "");
        parameterMap.put("courseJavaEE", "");
        parameterMap.put("coursePython", "");
        parameterMap.put("courseHTMLCSS", "");
        parameterMap.put("courseJavaScrip", "");
        parameterMap.put("coursePHPSQL", "");
        parameterMap.put("courseTester", "");
        parameterMap.put("teacherIvanov", "");
        parameterMap.put("teacherPetrov", "");
        parameterMap.put("teacherSidorov", "");
        parameterMap.put("gradeOne", "");
        parameterMap.put("gradeTwo", "");
        parameterMap.put("gradeThree", "");
        parameterMap.put("gradeFour", "");
        parameterMap.put("gradeFive", "");
        parameterMap.put("otherCourseJavaSE", "");
        parameterMap.put("otherCourseJavaEE", "");
        parameterMap.put("otherCoursePython", "");
        parameterMap.put("otherCourseHTMLCSS", "");
        parameterMap.put("otherCourseJavaScript", "");
        parameterMap.put("otherCoursePHPSQL", "");
        parameterMap.put("otherCourseTester", "");
        parameterMap.put("tv", "");
        parameterMap.put("radio", "");
        parameterMap.put("inet", "");
        parameterMap.put("metro", "");
        parameterMap.put("friends", "");
        parameterMap.put("other", "");
        parameterMap.put("otherText", "value=\"\"");
        parameterMap.put("recommendations", "value=\"\"");
    }

    public void setParameterForParameterMap(HttpServletRequest request) {


    }


    public Map<String, String> getParameterMap() {
        return parameterMap;
    }
}
