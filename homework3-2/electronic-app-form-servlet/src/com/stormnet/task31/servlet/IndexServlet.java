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
import java.util.Map;

@WebServlet("/index.html")
public class IndexServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Validation validation = (Validation) request.getAttribute("validation");
        if (validation == null) {
            validation = new Validation();
            request.setAttribute("validation", validation);
        }
        Map<String, String> errorsMap = validation.getErrorsMap();

        ParameterAssigner parameterAssigner = new ParameterAssigner();
        parameterAssigner.setParameterForParameterMap(request);
        Map<String, String> parameterMap = parameterAssigner.getParameterMap();

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
        writer.println("1. Фамилия*: "+errorsMap.get("last_name") +"<br>");
        writer.println("<input type=\"text\" name=\"last_name\" id=\"last_name\" " + parameterMap.get("last_name") + "/><br><br>");
        writer.println("2. Имя*: "+errorsMap.get("name")+"<br>");
        writer.println("<input type=\"text\" name=\"name\" id=\"name\" " + parameterMap.get("name") + "/><br><br>");
        writer.println("3. Отчество:<br>");
        writer.println("<input type=\"text\" name=\"middle_name\" id=\"middle_name\" " + parameterMap.get("middle_name") + "/><br><br>");
        writer.println("4. Секретная Фраза*: "+errorsMap.get("password")+"<br>");
        writer.println("<input type=\"password\" name=\"password\" id=\"password\" " + parameterMap.get("password") + "/><br><br>");
        writer.println("</div>");
        writer.println("<div class=\"sex size\">");
        writer.println("5. Возраст: "+errorsMap.get("age")+"<br>");
        writer.println("<input type=\"text\" name=\"age\" id=\"age\" " + parameterMap.get("age") + "/><br><br>");
        writer.println("6. Пол*: "+errorsMap.get("sex")+"<br>");
        writer.println("<label><input type=\"radio\" name=\"sex\" id=\"sex_men\" value=\"men\" " + parameterMap.get("sex_men") + "/>Мужской</label>");
        writer.println("<label><input type=\"radio\" name=\"sex\" id=\"sex_women\" value=\"women\" " + parameterMap.get("sex_women") + "/>Женский</label>");
        writer.println("<br/><br>");
        writer.println("</div>");
        writer.println("<div class=\"courses size\">");
        writer.println(" 7. Курс*: "+errorsMap.get("course")+"<br>");
        writer.println("<select name=\"course\" id=\"course\" onchange=\"disableSelectedCourseInOtherCourses()\">");
        writer.println("<option hidden></option>");
        writer.println("<option value=\"java_se\" " + parameterMap.get("course_java_se") + ">Java SE</option>");
        writer.println("<option value=\"java_ee\" " + parameterMap.get("course_java_ee") + ">Java EE</option>");
        writer.println("<option value=\"python\" " + parameterMap.get("course_python") + ">Python/Django</option>");
        writer.println("<option value=\"html_css\" " + parameterMap.get("course_html_css") + ">HTML и CSS</option>");
        writer.println("<option value=\"javascript\" " + parameterMap.get("course_javascript") + ">JavaScript (Angular)</option>");
        writer.println("<option value=\"php_sql\" " + parameterMap.get("course_php_sql") + ">PHP, MySQL, Laravel</option>");
        writer.println("<option value=\"tester\" " + parameterMap.get("course_tester") + ">Тестирование</option>");
        writer.println("</select><br><br>");
        writer.println("8. Преподаватель*: "+errorsMap.get("teacher")+"<br>");
        writer.println("<select name=\"teacher\" id=\"teacher\">");
        writer.println("<option hidden></option>");
        writer.println("<option value=\"ivanov\" " + parameterMap.get("teacher_ivanov") + ">Иванов Иван Иванович</option>");
        writer.println("<option value=\"petrov\" " + parameterMap.get("teacher_petrov") + ">Петров Петр Петрович</option>");
        writer.println("<option value=\"sidorov\" " + parameterMap.get("teacher_sidorov") + ">Сидоров Сидор Сидорович</option>");
        writer.println("</select><br><br>");
        writer.println("9. Оценка курса*: "+errorsMap.get("grade")+"<br>");
        writer.println("<select name=\"grade\" id=\"grade\">");
        writer.println("<option hidden></option>");
        writer.println("<option value=\"one\" " + parameterMap.get("grade_one") + ">1</option>");
        writer.println("<option value=\"two\" " + parameterMap.get("grade_two") + ">2</option>");
        writer.println("<option value=\"three\" " + parameterMap.get("grade_three") + ">3</option>");
        writer.println("<option value=\"four\" " + parameterMap.get("grade_four") + ">4</option>");
        writer.println("<option value=\"five\" " + parameterMap.get("grade_five") + ">5</option>");
        writer.println("</select><br><br>");
        writer.println("10. Прочие курсы*:<br>");
        writer.println("<select name=\"other_course[]\" id=\"other_course\" multiple=\"multiple\"");
        writer.println("title='Выбирете несколько вариантов");
        writer.println("при помощи Ctrl'");
        writer.println(">");
        writer.println("<option value=\"java_se\" " + parameterMap.get("otherCourse_java_se") + parameterMap.get("otherCourseDis_java_se") + ">Java SE</option>");
        writer.println("<option value=\"java_ee\" " + parameterMap.get("otherCourse_java_ee") + parameterMap.get("otherCourseDis_java_ee") + ">Java EE</option>");
        writer.println("<option value=\"python\" " + parameterMap.get("otherCourse_python") + parameterMap.get("otherCourseDis_python") + ">Python/Django</option>");
        writer.println("<option value=\"html_css\" " + parameterMap.get("otherCourse_html_css") + parameterMap.get("otherCourseDis_html_css") + ">HTML и CSS</option>");
        writer.println("<option value=\"javascript\" " + parameterMap.get("otherCourse_javascript") + parameterMap.get("otherCourseDis_javascript") + ">JavaScript (Angular)</option>");
        writer.println("<option value=\"php_sql\" " + parameterMap.get("otherCourse_php_sql") + parameterMap.get("otherCourseDis_php_sql") + ">PHP, MySQL, Laravel</option>");
        writer.println("<option value=\"tester\" " + parameterMap.get("otherCourse_tester") + parameterMap.get("otherCourseDis_tester") + ">Тестирование</option>");
        writer.println("</select><br><br>");
        writer.println("</div>");
        writer.println("<div class=\"other\">");
        writer.println("<div class=\"sources\">");
        writer.println("11. Как Вы о нас узнали*: "+errorsMap.get("sources")+"<br>");
        writer.println("<div class=\"left\">");
        writer.println("<label><input type=\"checkbox\" id=\"tv\" name=\"sources\" value=\"tv\" " + parameterMap.get("tv") + "/>Реклама по ТВ.</label><br>");
        writer.println("<label><input type=\"checkbox\" id=\"radio\" name=\"sources\" value=\"radio\" " + parameterMap.get("radio") + "/>Реклама по радио.</label><br>");
        writer.println("<label><input type=\"checkbox\" id=\"inet\" name=\"sources\" value=\"inet\" " + parameterMap.get("inet") + "/>Реклама в Интернете.</label>");
        writer.println("</div>");
        writer.println("<div class=\"right\">");
        writer.println("<label><input type=\"checkbox\" id=\"metro\" name=\"sources\" value=\"metro\" " + parameterMap.get("metro") + "/>Реклама в метро.</label><br>");
        writer.println("<label><input type=\"checkbox\" id=\"friends\" name=\"sources\" value=\"friends\" " + parameterMap.get("friends") + "/>От знакомых</label><br>");
        writer.println("<label><input type=\"checkbox\" id=\"other\" name=\"sources\" value=\"other\" " + parameterMap.get("other") + " onchange=\"enableOtherField()\"/>Другое</label>");
        writer.println("</div>");
        writer.println("</div>");
        writer.println("<div class=\"other\">");
        writer.println("12. Другое: "+errorsMap.get("other_text")+"<br>");
        writer.println("<textarea name=\"other_text\" id=\"other_text\" rows=\"3\" cols=\"30\" "+ parameterMap.get("other_text_disabled") +">" + parameterMap.get("other_text") + "</textarea><br><br>");
        writer.println("13. Прочие Рекомендации:<br>");
        writer.println("<textarea name=\"recommendations\" id=\"recommendations\" rows=\"3\" cols=\"30\">" + parameterMap.get("recommendations") + "</textarea><br><br>");
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
