<%@ page import="com.stormnet.task41.util.Validation" %>
<%@ page import="com.stormnet.task41.util.ValidationImpl" %>
<%@ page import="java.util.Map" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Result</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
</head>
<%
    Validation validation = new ValidationImpl();
    validation.validate(request.getParameterMap());

    if (!validation.isValidate()) {
        Map<String, String> errorsMap = validation.getErrorsMap();
        for (String errorName : errorsMap.keySet()) {
            request.setAttribute(errorName, errorsMap.get(errorName));
        }
        request.getRequestDispatcher("WEB-INF/pages/index.jsp").forward(request, response);
    }

%>
<body>
<table class="result_table">
    <tbody>
    <tr>
        <th>Name</th><th>Value</th>
    </tr>
    <tr><td>1. Фамилия:</td><td>${param.last_name}</td></tr>
    <tr><td>2. Имя:</td><td>${param.name}</td></tr>
    <tr><td>3. Отчество:</td><td>${param.middle_name}</td></tr>
    <tr><td>4. Секретная Фраза:</td><td>${param.password}</td></tr>
    <tr><td>5. Возраст:</td><td>${param.age}</td></tr>
    <tr><td>6. Пол:</td><td>${param.sex}</td></tr>
    <tr><td>7. Курс:</td><td>${param.course}</td></tr>
    <tr><td>8. Преподаватель:</td><td>${param.teacher}</td></tr>
    <tr><td>9. Оценка курса:</td><td>${param.grade}</td></tr>
    <%
            for (String value : request.getParameterValues("other_course")) {
    %>
    <tr><td>10. Прочие курсы:</td><td><%=value%></td></tr>
    <%
        }
            for (String value : request.getParameterValues("sources")) {
    %>
    <tr><td>11. Как Вы о нас узнали:</td><td><%=value%></td></tr>
    <%
        }
    %>
    <tr><td>12. Другое:</td><td>${param.other_text}</td></tr>
    <tr><td>13. Прочие Рекомендации:</td><td>${param.recommendations}</td></tr>
    </tbody>
</table>
</body>
</html>