<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ page isELIgnored="false" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Electronic application form servlet</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
    <script type="text/javascript" src="${pageContext.request.contextPath}/scripts/script.js" defer></script>
</head>
<body>
<h1>Электронная анкета<br>для оценки качества образования.</h1>

<form class="my_form" name="my_form" id="my_form" method="get" action="/controller.html">
    <div class="first size">
        1. Фамилия*: ${last_name}<br>
        <input type="text" name="last_name" id="last_name" value="${fn:escapeXml(param.last_name)}"/><br><br>
        2. Имя*: ${name}<br>
        <input type="text" name="name" id="name" value="${fn:escapeXml(param.name)}"/><br><br>
        3. Отчество:<br>
        <input type="text" name="middle_name" id="middle_name" value="${fn:escapeXml(param.middle_name)}"/><br><br>
        4. Секретная Фраза*: ${password}<br>
        <input type="password" name="password" id="password" value="${fn:escapeXml(param.password)}"/><br><br>
    </div>
    <div class="sex size">
        5. Возраст: ${age}<br>
        <input type="text" name="age" id="age" value="${fn:escapeXml(param.age)}"/><br><br>
        6. Пол*: ${sex}<br>
        <label><input type="radio" name="sex" id="sex_men" value="men" ${param.sex == 'men' ? 'checked' : ''}/>Мужской</label>
        <label><input type="radio" name="sex" id="sex_women" value="women" ${param.sex == 'women' ? 'checked' : ''}/>Женский</label>
        <br/><br>
    </div>
    <div class="courses size">
        7. Курс*: ${course}<br>
        <select name="course" id="course" onchange="disableSelectedCourseInOtherCourses()">
            <option hidden></option>
            <option value="java_se" ${param.course == 'java_se' ? 'selected' : ''}>Java SE</option>
            <option value="java_ee" ${param.course == 'java_ee' ? 'selected' : ''}>Java EE</option>
            <option value="python" ${param.course == 'python' ? 'selected' : ''}>Python/Django</option>
            <option value="html_css" ${param.course == 'html_css' ? 'selected' : ''}>HTML и CSS</option>
            <option value="javascript" ${param.course == 'javascript' ? 'selected' : ''}>JavaScript (Angular)</option>
            <option value="php_sql" ${param.course == 'php_sql' ? 'selected' : ''}>PHP, MySQL, Laravel</option>
            <option value="tester" ${param.course == 'tester' ? 'selected' : ''}>Тестирование</option>
        </select><br><br>
        8. Преподаватель*: ${teacher}<br>
        <select name="teacher" id="teacher">
            <option hidden></option>
            <option value="ivanov" ${param.teacher == 'ivanov' ? 'selected' : ''}>Иванов Иван Иванович</option>
            <option value="petrov" ${param.teacher == 'petrov' ? 'selected' : ''}>Петров Петр Петрович</option>
            <option value="sidorov" ${param.teacher == 'sidorov' ? 'selected' : ''}>Сидоров Сидор Сидорович</option>
        </select><br><br>
        9. Оценка курса*: ${grade}<br>
        <select name="grade" id="grade">
            <option hidden></option>
            <option value="one" ${param.grade == 'one' ? 'selected' : ''}>1</option>
            <option value="two" ${param.grade == 'two' ? 'selected' : ''}>2</option>
            <option value="three" ${param.grade == 'three' ? 'selected' : ''}>3</option>
            <option value="four" ${param.grade == 'four' ? 'selected' : ''}>4</option>
            <option value="five" ${param.grade == 'five' ? 'selected' : ''}>5</option>
        </select><br><br>
        10. Прочие курсы:<br>
        <select name="other_course" id="other_course" multiple="multiple"
                title='Выбирете несколько вариантов
                       при помощи Ctrl'
        >
            <option value="java_se" ${paramValues.other_course.stream().anyMatch(v->v == 'java_se').get() ? 'selected' : ''} ${param.course == 'java_se' ? 'disabled' : ''} >Java SE</option>
            <option value="java_ee" ${paramValues.other_course.stream().anyMatch(v->v == 'java_ee').get() ? 'selected' : ''} ${param.course == 'java_ee' ? 'disabled' : ''}>Java EE</option>
            <option value="python" ${paramValues.other_course.stream().anyMatch(v->v == 'python').get() ? 'selected' : ''} ${param.course == 'python' ? 'disabled' : ''}>Python/Django</option>
            <option value="html_css" ${paramValues.other_course.stream().anyMatch(v->v == 'html_css').get() ? 'selected' : ''} ${param.course == 'html_css' ? 'disabled' : ''}>HTML и CSS</option>
            <option value="javascript" ${paramValues.other_course.stream().anyMatch(v->v == 'javascript').get() ? 'selected' : ''} ${param.course == 'javascript' ? 'disabled' : ''}>JavaScript (Angular)</option>
            <option value="php_sql" ${paramValues.other_course.stream().anyMatch(v->v == 'php_sql').get() ? 'selected' : ''} ${param.course == 'php_sql' ? 'disabled' : ''}>PHP, MySQL, Laravel</option>
            <option value="tester" ${paramValues.other_course.stream().anyMatch(v->v == 'tester').get() ? 'selected' : ''} ${param.course == 'tester' ? 'disabled' : ''}>Тестирование</option>
        </select><br><br>
    </div>
    <div class="other">
        <div class="sources">
            11. Как Вы о нас узнали*: ${sources}<br>
            <div class="left">
                <label><input type="checkbox" id="tv" name="sources" value="tv" ${paramValues.sources.stream().anyMatch(v->v == 'tv').get() ? 'checked' : ''}/>Реклама по ТВ.</label><br>
                <label><input type="checkbox" id="radio" name="sources" value="radio" ${paramValues.sources.stream().anyMatch(v->v == 'radio').get() ? 'checked' : ''}/>Реклама по радио.</label><br>
                <label><input type="checkbox" id="inet" name="sources" value="inet" ${paramValues.sources.stream().anyMatch(v->v == 'inet').get() ? 'checked' : ''}/>Реклама в Интернете.</label>
            </div>

            <div class="right">
                <label><input type="checkbox" id="metro" name="sources" value="metro" ${paramValues.sources.stream().anyMatch(v->v == 'metro').get() ? 'checked' : ''}/>Реклама в метро.</label><br>
                <label><input type="checkbox" id="friends" name="sources" value="friends" ${paramValues.sources.stream().anyMatch(v->v == 'friends').get() ? 'checked' : ''}/>От знакомых</label><br>
                <label><input type="checkbox" id="other" name="sources" value="other" ${paramValues.sources.stream().anyMatch(v->v == 'other').get() ? 'checked' : ''} onchange="enableOtherField()"/>Другое</label>
            </div>
        </div>

        <div class="other">
            12. Другое: ${other_text}<br>
            <textarea name="other_text" id="other_text" rows="3" cols="30" ${paramValues.sources.stream().anyMatch(v->v == 'other').get() ? '' : 'disabled'}>${fn:escapeXml(param.other_text)}</textarea><br><br>
            13. Прочие Рекомендации:<br>
            <textarea name="recommendations" id="recommendations" rows="3"
                      cols="30">${fn:escapeXml(param.recommendations)}</textarea><br><br>
        </div>
    </div>

    <div class="button">
        <input type="button" id="true_answer" name="true_answer" value="Отправить – здесь все правда"/>
        <input type="button" id="false_answer" name="false_answer" value="Отправить – я все равно все наврал"/>
    </div>
</form>

<label><input type="checkbox" id="validation" name="validation"/>Отключить валидацию HTML</label>

</body>
</html>
