package com.stormnet.task31.servlet;

import com.stormnet.task31.util.ParameterAssigner;
import com.stormnet.task31.util.Validation;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/index.html")
public class IndexServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Validation validation = (Validation) request.getAttribute("validation");
        if (validation == null) {
            validation = new Validation();
            request.setAttribute("validation", validation);
        }

        ParameterAssigner parameterAssigner = new ParameterAssigner();
        parameterAssigner.setParameterForParameterMap(request);

        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();

        writer.println("<!DOCTYPE html>");
        writer.println("<html>");
        writer.println("<head>");
        writer.println("<meta charset=\" UTF - 8\">");
        writer.println("<title>Electronic application form servlet</title>");
        writer.println("<link rel = \"stylesheet\" href = \"css/style.css\">");
        writer.println("<script type = \"text/javascript\" src = \"scripts/script.js\" defer ></script>");
        writer.println("</head>");
        writer.println("<body>");
        writer.println("<h1> Электронная анкета<br> для оценки качества образования.</h1>");
        writer.println("<form class=\"my_form\" name=\"my_form\" id=\"my_form\" method=\"get\" action=\"/result-servlet.html\">");
        writer.println("<div class=\"first size\">");
        writer.println("1. Фамилия*: " + validation.getValidationError("last_name") + "<br>");
        writer.println("<input type=\"text\" name=\"last_name\" id=\"last_name\" " + parameterAssigner.getParameterValue("last_name") + "/><br><br>");
        writer.println("2. Имя*: " + validation.getValidationError("name") + "<br>");
        writer.println("<input type=\"text\" name=\"name\" id=\"name\" " + parameterAssigner.getParameterValue("name") + "/><br><br>");
        writer.println("3. Отчество:<br>");
        writer.println("<input type=\"text\" name=\"middle_name\" id=\"middle_name\" " + parameterAssigner.getParameterValue("middle_name") + "/><br><br>");
        writer.println("4. Секретная Фраза*: " + validation.getValidationError("password") + "<br>");
        writer.println("<input type=\"password\" name=\"password\" id=\"password\" " + parameterAssigner.getParameterValue("password") + "/><br><br>");
        writer.println("</div>");
        writer.println("<div class=\"sex size\">");
        writer.println("5. Возраст: " + validation.getValidationError("age") + "<br>");
        writer.println("<input type=\"text\" name=\"age\" id=\"age\" " + parameterAssigner.getParameterValue("age") + "/><br><br>");
        writer.println("6. Пол*: " + validation.getValidationError("sex") + "<br>");
        writer.println("<label><input type=\"radio\" name=\"sex\" id=\"sex_men\" value=\"men\" " + parameterAssigner.getParameterValue("sex_men") + "/>Мужской</label>");
        writer.println("<label><input type=\"radio\" name=\"sex\" id=\"sex_women\" value=\"women\" " + parameterAssigner.getParameterValue("sex_women") + "/>Женский</label>");
        writer.println("<br/><br>");
        writer.println("</div>");
        writer.println("<div class=\"courses size\">");
        writer.println(" 7. Курс*: " + validation.getValidationError("course") + "<br>");
        writer.println("<select name=\"course\" id=\"course\" onchange=\"disableSelectedCourseInOtherCourses()\">");
        writer.println("<option hidden></option>");
        writer.println("<option value=\"java_se\" " + parameterAssigner.getParameterValue("course_java_se") + ">Java SE</option>");
        writer.println("<option value=\"java_ee\" " + parameterAssigner.getParameterValue("course_java_ee") + ">Java EE</option>");
        writer.println("<option value=\"python\" " + parameterAssigner.getParameterValue("course_python") + ">Python/Django</option>");
        writer.println("<option value=\"html_css\" " + parameterAssigner.getParameterValue("course_html_css") + ">HTML и CSS</option>");
        writer.println("<option value=\"javascript\" " + parameterAssigner.getParameterValue("course_javascript") + ">JavaScript (Angular)</option>");
        writer.println("<option value=\"php_sql\" " + parameterAssigner.getParameterValue("course_php_sql") + ">PHP, MySQL, Laravel</option>");
        writer.println("<option value=\"tester\" " + parameterAssigner.getParameterValue("course_tester") + ">Тестирование</option>");
        writer.println("</select><br><br>");
        writer.println("8. Преподаватель*: " + validation.getValidationError("teacher") + "<br>");
        writer.println("<select name=\"teacher\" id=\"teacher\">");
        writer.println("<option hidden></option>");
        writer.println("<option value=\"ivanov\" " + parameterAssigner.getParameterValue("teacher_ivanov") + ">Иванов Иван Иванович</option>");
        writer.println("<option value=\"petrov\" " + parameterAssigner.getParameterValue("teacher_petrov") + ">Петров Петр Петрович</option>");
        writer.println("<option value=\"sidorov\" " + parameterAssigner.getParameterValue("teacher_sidorov") + ">Сидоров Сидор Сидорович</option>");
        writer.println("</select><br><br>");
        writer.println("9. Оценка курса*: " + validation.getValidationError("grade") + "<br>");
        writer.println("<select name=\"grade\" id=\"grade\">");
        writer.println("<option hidden></option>");
        writer.println("<option value=\"one\" " + parameterAssigner.getParameterValue("grade_one") + ">1</option>");
        writer.println("<option value=\"two\" " + parameterAssigner.getParameterValue("grade_two") + ">2</option>");
        writer.println("<option value=\"three\" " + parameterAssigner.getParameterValue("grade_three") + ">3</option>");
        writer.println("<option value=\"four\" " + parameterAssigner.getParameterValue("grade_four") + ">4</option>");
        writer.println("<option value=\"five\" " + parameterAssigner.getParameterValue("grade_five") + ">5</option>");
        writer.println("</select><br><br>");
        writer.println("10. Прочие курсы*:<br>");
        writer.println("<select name=\"other_course[]\" id=\"other_course\" multiple=\"multiple\"");
        writer.println("title='Выбирете несколько вариантов");
        writer.println("при помощи Ctrl'");
        writer.println(">");
        writer.println("<option value=\"java_se\" " + parameterAssigner.getParameterValue("otherCourse_java_se") + parameterAssigner.getParameterValue("otherCourseDis_java_se") + ">Java SE</option>");
        writer.println("<option value=\"java_ee\" " + parameterAssigner.getParameterValue("otherCourse_java_ee") + parameterAssigner.getParameterValue("otherCourseDis_java_ee") + ">Java EE</option>");
        writer.println("<option value=\"python\" " + parameterAssigner.getParameterValue("otherCourse_python") + parameterAssigner.getParameterValue("otherCourseDis_python") + ">Python/Django</option>");
        writer.println("<option value=\"html_css\" " + parameterAssigner.getParameterValue("otherCourse_html_css") + parameterAssigner.getParameterValue("otherCourseDis_html_css") + ">HTML и CSS</option>");
        writer.println("<option value=\"javascript\" " + parameterAssigner.getParameterValue("otherCourse_javascript") + parameterAssigner.getParameterValue("otherCourseDis_javascript") + ">JavaScript (Angular)</option>");
        writer.println("<option value=\"php_sql\" " + parameterAssigner.getParameterValue("otherCourse_php_sql") + parameterAssigner.getParameterValue("otherCourseDis_php_sql") + ">PHP, MySQL, Laravel</option>");
        writer.println("<option value=\"tester\" " + parameterAssigner.getParameterValue("otherCourse_tester") + parameterAssigner.getParameterValue("otherCourseDis_tester") + ">Тестирование</option>");
        writer.println("</select><br><br>");
        writer.println("</div>");
        writer.println("<div class=\"other\">");
        writer.println("<div class=\"sources\">");
        writer.println("11. Как Вы о нас узнали*: " + validation.getValidationError("sources") + "<br>");
        writer.println("<div class=\"left\">");
        writer.println("<label><input type=\"checkbox\" id=\"tv\" name=\"sources\" value=\"tv\" " + parameterAssigner.getParameterValue("tv") + "/>Реклама по ТВ.</label><br>");
        writer.println("<label><input type=\"checkbox\" id=\"radio\" name=\"sources\" value=\"radio\" " + parameterAssigner.getParameterValue("radio") + "/>Реклама по радио.</label><br>");
        writer.println("<label><input type=\"checkbox\" id=\"inet\" name=\"sources\" value=\"inet\" " + parameterAssigner.getParameterValue("inet") + "/>Реклама в Интернете.</label>");
        writer.println("</div>");
        writer.println("<div class=\"right\">");
        writer.println("<label><input type=\"checkbox\" id=\"metro\" name=\"sources\" value=\"metro\" " + parameterAssigner.getParameterValue("metro") + "/>Реклама в метро.</label><br>");
        writer.println("<label><input type=\"checkbox\" id=\"friends\" name=\"sources\" value=\"friends\" " + parameterAssigner.getParameterValue("friends") + "/>От знакомых</label><br>");
        writer.println("<label><input type=\"checkbox\" id=\"other\" name=\"sources\" value=\"other\" " + parameterAssigner.getParameterValue("other") + " onchange=\"enableOtherField()\"/>Другое</label>");
        writer.println("</div>");
        writer.println("</div>");
        writer.println("<div class=\"other\">");
        writer.println("12. Другое: " + validation.getValidationError("other_text") + "<br>");
        writer.println("<textarea name=\"other_text\" id=\"other_text\" rows=\"3\" cols=\"30\" " + parameterAssigner.getParameterValue("other_text_disabled") + ">" + parameterAssigner.getParameterValue("other_text") + "</textarea><br><br>");
        writer.println("13. Прочие Рекомендации:<br>");
        writer.println("<textarea name=\"recommendations\" id=\"recommendations\" rows=\"3\" cols=\"30\">" + parameterAssigner.getParameterValue("recommendations") + "</textarea><br><br>");
        writer.println("</div>");
        writer.println("</div>");
        writer.println("<div class=\"button\">");
        writer.println("<input type=\"button\" id=\"true_answer\" name=\"true_answer\" value=\"Отправить – здесь все правда\"/>");
        writer.println("<input type=\"button\" id=\"false_answer\" name=\"false_answer\" value=\"Отправить – я все равно все наврал\"/>");
        writer.println("</div>");
        writer.println("</form>");
        writer.println("<label><input type=\"checkbox\" id=\"validation\" name=\"validation\" />Отключить валидацию HTML</label>");
        writer.println("<div class=\"result\">");
        writer.println("<div class=\"inner_result\" id=\"inner_result\"></div>");
        writer.println("</div>");
        writer.println("</body>");
        writer.println("</html>");
    }
}
