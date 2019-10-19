<%@ page import="com.stormnet.task41.util.Validation" %>
<%@ page import="com.stormnet.task41.util.ValidationImpl" %>
<%@ page import="java.util.Map" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ page isELIgnored="false" %>
<%
    response.setCharacterEncoding("utf-8");

    Validation validation = new ValidationImpl();
    validation.validate(request.getParameterMap());
    if (!validation.isValidate()) {
        Map<String, String> errorsMap = validation.getErrorsMap();
        for (String param : errorsMap.keySet()) {
            request.setAttribute(param, errorsMap.get(param));
        }
    }
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Result</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
</head>
<body>
<table class="result_table">
    <tbody>
    <tr>
        <th>Name</th>
        <th>Value</th>
    </tr>
    <tr>
        <td>1. Фамилия:</td>
        <td>${last_name == null ? param.last_name : last_name}</td>
    </tr>
    <tr>
        <td>2. Имя:</td>
        <td>${name == null ? param.name : name}</td>
    </tr>
    <tr>
        <td>3. Отчество:</td>
        <td>${param.middle_name}</td>
    </tr>
    <tr>
        <td>4. Секретная Фраза:</td>
        <td>${password == null ? param.password : password}</td>
    </tr>
    <tr>
        <td>5. Возраст:</td>
        <td>${age == null ? param.age : age }</td>
    </tr>
    <tr>
        <td>6. Пол:</td>
        <td>${sex == null ? param.sex : sex}</td>
    </tr>
    <tr>
        <td>7. Курс:</td>
        <td>${course == null ? param.course : course}</td>
    </tr>
    <tr>
        <td>8. Преподаватель:</td>
        <td>${teacher == null ? param.teacher : teacher}</td>
    </tr>
    <tr>
        <td>9. Оценка курса:</td>
        <td>${grade == null ? param.grade : grade}</td>
    </tr>
    <%
        String[] values = request.getParameterValues("other_course");
        if (values != null && values.length > 0) {
            for (String value : values) {
    %>
    <tr>
        <td>10. Прочие курсы:</td>
        <td><%=value%>
        </td>
    </tr>
    <%
            }
        }
        String[] sourcesValues = request.getParameterValues("sources");
        if (sourcesValues != null && sourcesValues.length > 0) {
            for (String value : request.getParameterValues("sources")) {
    %>
    <tr>
        <td>11. Как Вы о нас узнали:</td>
        <td><%=value%>
        </td>
    </tr>
    <%
        }
    } else {
    %>
    <tr>
        <td>11. Как Вы о нас узнали:</td>
        <td>${sources}</td>
    </tr>
    <%
        }
    %>
    <tr>
        <td>12. Другое:</td>
        <td>${other_text == null ? param.other_text : other_text}</td>
    </tr>
    <tr>
        <td>13. Прочие Рекомендации:</td>
        <td>${param.recommendations}</td>
    </tr>
    </tbody>
</table>
</body>
</html>