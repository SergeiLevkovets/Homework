<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ page isELIgnored="false" %>

<%
    Integer percentage = Integer.valueOf((String) session.getAttribute("percentage"));
    String resultMesage = "";
    if (percentage < 26) {
        resultMesage = "Неудовлетворительно";
    }else if (percentage >= 26 && percentage <=50){
        resultMesage = "Удовлетворительно";
    }else if (percentage >= 51 && percentage <=75){
        resultMesage = "Удовлетворительно";
    }else if (percentage >= 76){
        resultMesage = "Отлично";
    }
    pageContext.setAttribute("result_mesage", resultMesage);

%>

<%@include file="/WEB-INF/pages/header.jsp"%>
<div class="pricing-header px-1 text-center">
    <h2 class="display-6">Поздравляем! Тестирование окончено</h2>
    <p class="lead">Ваш результат: <span class="badge badge-info">(${percentage}%)</span></p>
    <p>Это - ${result_mesage}</p>
    <br>
    <button type="button" class="btn btn-info" onclick="location.href='/index.html'">Пройти тест еще раз</button>
</div>
<%@include file="/WEB-INF/pages/footer.jsp"%>
<%
    session.invalidate();
%>
