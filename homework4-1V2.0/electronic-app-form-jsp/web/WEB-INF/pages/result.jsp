<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ page isELIgnored="false" %>
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
    <c:forEach var="value" items="${paramValues.other_course}">
        <tr><td>10. Прочие курсы:</td><td>${value}</td></tr>
    </c:forEach>
    <c:forEach var="value" items="${paramValues.sources}">
        <tr><td>11. Как Вы о нас узнали:</td><td>${value}</td></tr>
    </c:forEach>
    <tr><td>12. Другое:</td><td>${param.other_text}</td></tr>
    <tr><td>13. Прочие Рекомендации:</td><td>${param.recommendations}</td></tr>
    </tbody>
</table>
</body>
</html>