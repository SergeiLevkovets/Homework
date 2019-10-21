<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ page isELIgnored="false" %>


<%@include file="/WEB-INF/pages/header.jsp"%>
<body>
<div class="pricing-header px-1 text-center">
    <h2 class="display-6">Добрый день! Проверте свои знания арифметики</h2>
    <p class="lead">Правильных ответов на данный момент: <span class="badge badge-info">X</span> из
        <span class="badge badge-info">Y</span> <span class="badge badge-info">(Z%)</span></p>
</div>
<div class="container">
    <div class="row border rounded mb-1 shadow-sm">
        <div class="col-auto p-2">Сейчас проверяется:</div>
        <div class="col p-2 ">
            <div class="form-check-inline ">
                <input class="form-check-input" type="radio" name="math_operation" id="addition"
                       value="addition" disabled checked>
                <label class="form-check-label text-primary" for="addition">
                    Сложение
                </label>
            </div>
            <div class="form-check-inline">
                <input class="form-check-input" type="radio" name="math_operation" id="subtraction"
                       value="subtraction" disabled>
                <label class="form-check-label" for="subtraction">
                    Вычитание
                </label>
            </div>
            <div class="form-check-inline">
                <input class="form-check-input" type="radio" name="math_operation" id="multiplication"
                       value="multiplication" disabled>
                <label class="form-check-label" for="multiplication">
                    Умножение
                </label>
            </div>
            <div class="form-check-inline">
                <input class="form-check-input" type="radio" name="math_operation" id="division"
                       value="division" disabled>
                <label class="form-check-label" for="division">
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
            пример 2 + 2
        </div>
    </div>
    <div class="row border rounded  mb-1 shadow-sm ">
        <div class="col-auto p-2">
            <form role="form" class="form" id="form" method="get" action="/result.html">
                <div class="btn-group">
                    <div class="btn-group-vertical">
                        <label class="btn btn-secondary text-left">
                            <input type="radio" name="answer" id="first" value="first"> 1
                        </label>
                        <label class="btn btn-secondary text-left">
                            <input type="radio" name="answer" id="second" value="second"> 2
                        </label>
                        <label class="btn btn-secondary text-left">
                            <input type="radio" name="answer" id="third" value="third"> 3
                        </label>
                        <label class="btn btn-secondary text-left">
                            <input type="radio" name="answer" id="fourth" value="fourth"> 4
                        </label>
                    </div>
                </div>
            </form>
        </div>
        <div class="col text-center p-4">
            <p class="text-success">«Поздравляем! Это правильный ответ!»</p>
            <p class="text-danger">«К сожалению, ответ не верный. Сосредоточьтесь!»</p>
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
                <button type="button" class="btn btn-primary" onclick="document.getElementById('form').submit()">Ок</button>
            </div>
        </div>
    </div>
</div>
<%@include file="/WEB-INF/pages/footer.jsp"%>