<%@ page import="com.stormnet.task44.util.MyRandomParameter" %>
<%@ page import="com.stormnet.task44.service.Service" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ page isELIgnored="false" %>

<%
    Integer numberOfTask = (Integer) session.getAttribute("number_of_task");
    if (numberOfTask == null) {
        numberOfTask = 0;
    }

    Integer correctAnswer = (Integer) session.getAttribute("correct_answer");
    if (correctAnswer == null) {
        correctAnswer = 0;
    }

    Integer validAnswer = (Integer) session.getAttribute("valid_answer");
    if (validAnswer != null) {
        String testAnswer = request.getParameter("test_answer");
        if ( testAnswer == null) {
            session.setAttribute("message","<p>Вы пропустили вопрос</p>");
        } else {
            if (testAnswer.equals(validAnswer.toString())){
                session.setAttribute("message",
                        "<p class=\"text-success\">«Поздравляем! Это правильный ответ!»</p>");
                correctAnswer++;
            }else {
                session.setAttribute("message",
                        "<p class=\"text-danger\">«К сожалению, ответ не верный. Сосредоточьтесь!»</p>");
            }
        }
        numberOfTask++;
    }

    String percentageOfCorAnswer = numberOfTask == 0 ? "0" : String.valueOf(Math.round(((double) correctAnswer / numberOfTask)*100));
    session.setAttribute("percentage", percentageOfCorAnswer);
    session.setAttribute("correct_answer", correctAnswer);
    session.setAttribute("number_of_task", numberOfTask);

    String mathOperation = MyRandomParameter.getRandomMathOperation();
    session.setAttribute("math_operation", mathOperation);
    String mathOperationSymbol = MyRandomParameter.getMathOperationSymbol(mathOperation);
    session.setAttribute("math_operation_symbol", mathOperationSymbol);
    int firstNumber = MyRandomParameter.getAnyLargeNumber();
    session.setAttribute("first_number", firstNumber);
    int secondNumber = MyRandomParameter.getAnyLargeNumber();
    session.setAttribute("second_number", secondNumber);

    int answer = Service.getMathAnswer(firstNumber, secondNumber, mathOperation);
    session.setAttribute("valid_answer", answer);
    int[] answerArr = Service.getResultArr(answer);
    session.setAttribute("answers", answerArr);

%>


<%@include file="/WEB-INF/pages/header.jsp"%>
<body>
<div class="pricing-header px-1 text-center">
    <h2 class="display-6">Добрый день! Проверте свои знания арифметики</h2>
    <p class="lead">Правильных ответов на данный момент: <span class="badge badge-info">${correct_answer}</span> из
        <span class="badge badge-info">${number_of_task}</span> <span class="badge badge-info">(${percentage}%)</span></p>
</div>
<div class="container">
    <div class="row border rounded mb-1 shadow-sm">
        <div class="col-auto p-2">Сейчас проверяется:</div>
        <div class="col p-2 ">
            <div class="form-check-inline ">
                <input class="form-check-input" type="radio" name="math_operation" id="addition"
                       value="addition" disabled ${math_operation == 'addition' ? 'checked' : ''}>
                <label class="form-check-label ${math_operation == 'addition' ? 'text-primary' : ''}" for="addition">
                    Сложение
                </label>
            </div>
            <div class="form-check-inline">
                <input class="form-check-input" type="radio" name="math_operation" id="subtraction"
                       value="subtraction" disabled ${math_operation == 'subtraction' ? 'checked' : ''}>
                <label class="form-check-label ${math_operation == 'subtraction' ? 'text-primary' : ''}" for="subtraction">
                    Вычитание
                </label>
            </div>
            <div class="form-check-inline">
                <input class="form-check-input" type="radio" name="math_operation" id="multiplication"
                       value="multiplication" disabled ${math_operation == 'multiplication' ? 'checked' : ''}>
                <label class="form-check-label ${math_operation == 'multiplication' ? 'text-primary' : ''}" for="multiplication">
                    Умножение
                </label>
            </div>
            <div class="form-check-inline">
                <input class="form-check-input" type="radio" name="math_operation" id="division"
                       value="division" disabled ${math_operation == 'division' ? 'checked' : ''}>
                <label class="form-check-label ${math_operation == 'division' ? 'text-primary' : ''}" for="division">
                    Остаток от деления
                </label>
            </div>
        </div>
    </div>
    <div class="row border rounded  mb-1 shadow-sm ">
        <div class="col-sm p-2">
            Сколько будет:
        </div>
        <div class="col-sm p-2">
            ${first_number} ${math_operation_symbol} ${second_number}
        </div>
    </div>
    <div class="row border rounded  mb-1 shadow-sm ">
        <div class="col-auto p-2">
            <form role="form" class="form" id="form" method="get" action="/index.html">
                <div class="btn-group">
                    <div class="btn-group-vertical">
                        <label class="btn btn-secondary text-left" onclick="setTimeout(function(){$('#form').submit()}, 1000)">
                            <input type="radio" name="test_answer" id="first" value="${answers[0]}"> ${answers[0]}
                        </label>
                        <label class="btn btn-secondary text-left" onclick="setTimeout(function(){$('#form').submit()}, 1000)">
                            <input type="radio" name="test_answer" id="second" value="${answers[1]}"> ${answers[1]}
                        </label>
                        <label class="btn btn-secondary text-left" onclick="setTimeout(function(){$('#form').submit()}, 1000)">
                            <input type="radio" name="test_answer" id="third" value="${answers[2]}"> ${answers[2]}
                        </label>
                        <label class="btn btn-secondary text-left" onclick="setTimeout(function(){$('#form').submit()}, 1000)">
                            <input type="radio" name="test_answer" id="fourth" value="${answers[3]}"> ${answers[3]}
                        </label>
                    </div>
                </div>
            </form>
        </div>
        <div class="col text-center p-4">
            ${message}
        </div>
    </div>
    <button type="button" class="btn btn-success" data-toggle="modal" data-target="#skipButton">Следующее
        задание
    </button>
    <button type="button" class="btn btn-danger" data-toggle="modal" data-target="#cancelButton">Закончить тестирование</button>
</div>
<!-- Modal -->
<div class="modal fade" id="skipButton" tabindex="-1" role="dialog" aria-labelledby="skipButtonLongTitle"
     aria-hidden="true">
    <div class="modal-dialog modal-dialog-centered" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="skipButtonLongTitle">Подтвердить пропуск вопроса</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <p>Текущий ответ не будет защитан</p>
                <p>Вы уверены что хотите пропустить вопрос</p>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">Закрыть</button>
                <button type="button" class="btn btn-primary" onclick="$('#form').submit()">Ок</button>
            </div>
        </div>
    </div>
</div>

<div class="modal fade" id="cancelButton" tabindex="-1" role="dialog" aria-labelledby="cancelButtonTitle"
     aria-hidden="true">
    <div class="modal-dialog modal-dialog-centered" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="cancelButtonTitle">Подтвердить окончание теста</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <p>Вы готовы закончить тест и посмотреть результаты</p>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">Закрыть</button>
                <button type="button" class="btn btn-primary" onclick="location.href='/result.html'">Ок</button>
            </div>
        </div>
    </div>
</div>
<%@include file="/WEB-INF/pages/footer.jsp"%>