<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ page isELIgnored="false" %>
<%
    if (request.getAttribute("other_text_disabled") == null) {
        request.setAttribute("other_text_disabled", "disabled");
    }
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Electronic application form servlet</title>
    <link rel="stylesheet" href="css/style.css">
    <script type="text/javascript" src="scripts/script.js" defer></script>
</head>
<body>
<h1>Электронная анкета<br>для оценки качества образования.</h1>

<form class="my_form" name="my_form" id="my_form" method="get" action="/controller.html">
    <div class="first size">
        1. Фамилия*: ${last_name_err}<br>
        <input type="text" name="last_name" id="last_name" value="${last_name}"/><br><br>
        2. Имя*: ${name_err}<br>
        <input type="text" name="name" id="name" value="${name}"/><br><br>
        3. Отчество:<br>
        <input type="text" name="middle_name" id="middle_name" value="${middle_name}"/><br><br>
        4. Секретная Фраза*: ${password_err}<br>
        <input type="password" name="password" id="password" value="${password}"/><br><br>
    </div>
    <div class="sex size">
        5. Возраст: ${age_err}<br>
        <input type="text" name="age" id="age" value="${age}"/><br><br>
        6. Пол*: ${sex_err}<br>
        <label><input type="radio" name="sex" id="sex_men" value="men" ${sex_men}/>Мужской</label>
        <label><input type="radio" name="sex" id="sex_women" value="women" ${sex_women}/>Женский</label>
        <br/><br>
    </div>
    <div class="courses size">
        7. Курс*: ${course_err}<br>
        <select name="course" id="course" onchange="disableSelectedCourseInOtherCourses()">
            <option hidden></option>
            <option value="java_se" ${course_java_se}>Java SE</option>
            <option value="java_ee" ${course_java_ee}>Java EE</option>
            <option value="python" ${course_python}>Python/Django</option>
            <option value="html_css" ${course_html_css}>HTML и CSS</option>
            <option value="javascript" ${course_javascript}>JavaScript (Angular)</option>
            <option value="php_sql" ${course_php_sql}>PHP, MySQL, Laravel</option>
            <option value="tester" ${course_tester}>Тестирование</option>
        </select><br><br>
        8. Преподаватель*: ${teacher_err}<br>
        <select name="teacher" id="teacher">
            <option hidden></option>
            <option value="ivanov" ${teacher_ivanov}>Иванов Иван Иванович</option>
            <option value="petrov" ${teacher_petrov}>Петров Петр Петрович</option>
            <option value="sidorov" ${teacher_sidorov}>Сидоров Сидор Сидорович</option>
        </select><br><br>
        9. Оценка курса*: ${grade_err}<br>
        <select name="grade" id="grade">
            <option hidden></option>
            <option value="one" ${grade_one}>1</option>
            <option value="two" ${grade_two}>2</option>
            <option value="three" ${grade_three}>3</option>
            <option value="four" ${grade_four}>4</option>
            <option value="five" ${grade_five}>5</option>
        </select><br><br>
        10. Прочие курсы:<br>
        <select name="other_course[]" id="other_course" multiple="multiple"
                title='Выбирете несколько вариантов
                       при помощи Ctrl'
        >
            <option value="java_se" ${otherCourse_java_se} ${otherCourseDis_java_se} >Java SE</option>
            <option value="java_ee" ${otherCourse_java_ee} ${otherCourseDis_java_ee}>Java EE</option>
            <option value="python" ${otherCourse_python} ${otherCourseDis_python}>Python/Django</option>
            <option value="html_css" ${otherCourse_html_css} ${otherCourseDis_html_css}>HTML и CSS</option>
            <option value="javascript" ${otherCourse_javascript} ${otherCourseDis_javascript}>JavaScript (Angular)
            </option>
            <option value="php_sql" ${otherCourse_php_sql} ${otherCourseDis_php_sql}>PHP, MySQL, Laravel</option>
            <option value="tester" ${otherCourse_tester} ${otherCourseDis_tester}>Тестирование</option>
        </select><br><br>
    </div>
    <div class="other">
        <div class="sources">
            11. Как Вы о нас узнали*: ${sources_err}<br>
            <div class="left">
                <label><input type="checkbox" id="tv" name="sources" value="tv" ${tv}/>Реклама по ТВ.</label><br>
                <label><input type="checkbox" id="radio" name="sources" value="radio" ${radio}/>Реклама по
                    радио.</label><br>
                <label><input type="checkbox" id="inet" name="sources" value="inet" ${inet}/>Реклама в
                    Интернете.</label>
            </div>

            <div class="right">
                <label><input type="checkbox" id="metro" name="sources" value="metro" ${metro}/>Реклама в метро.</label><br>
                <label><input type="checkbox" id="friends" name="sources" value="friends" ${friends}/>От
                    знакомых</label><br>
                <label><input type="checkbox" id="other" name="sources" value="other" ${other}
                              onchange="enableOtherField()"/>Другое</label>
            </div>
        </div>

        <div class="other">
            12. Другое: ${other_text_err}<br>
            <textarea name="other_text" id="other_text" rows="3"
                      cols="30" ${other_text_disabled}>${other_text}</textarea><br><br>
            13. Прочие Рекомендации:<br>
            <textarea name="recommendations" id="recommendations" rows="3"
                      cols="30">${recommendations}</textarea><br><br>
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
