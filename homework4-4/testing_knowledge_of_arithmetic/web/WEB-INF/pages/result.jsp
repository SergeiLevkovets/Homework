<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ page isELIgnored="false" %>

<%

%>

<%@include file="/WEB-INF/pages/header.jsp"%>
<div class="pricing-header px-1 text-center">
    <h2 class="display-6">Поздравляем! Тестирование окончено</h2>
    <p class="lead">Ваш результат: <span class="badge badge-info">(Z%)</span></p>
    <p>Это - ОТЛИЧНО</p>
    <br>
    <button type="button" class="btn btn-info" onclick="location.href='/index.html'">Пройти тест еще раз</button>
</div>
<%@include file="/WEB-INF/pages/footer.jsp"%>
