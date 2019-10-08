package com.stormnet.task31.servlet;

import com.stormnet.task31.util.Validation;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

public class MyServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();
        Map<String, String[]> parameterMap = Validation.validationMap(request);

        writer.println("<!DOCTYPE html>");
        writer.println("<html>");
        writer.println("<head>");
        writer.println("<meta charset=\"UTF-8\">");
        writer.println("<title>Result</title>");
        writer.println("<link rel=\"stylesheet\" href=\"css/style.css\">");
        writer.println("</head>");
        writer.println("<body>");
        writer.println("<table class=\"result_table\">");
        writer.println("<tbody>");
        writer.println("<tr>");
        writer.println("<th>Name</th><th>Value</th>");
        writer.println("</tr>");

        for (String param : parameterMap.keySet()) {
            for (String value : parameterMap.get(param)) {
                writer.println("<tr><td>" + param + "</td><td>" + value + "</td></tr>");
            }
        }
        writer.println("</tbody>");
        writer.println("</table>");
        writer.println("</body>");
        writer.println("</html>");
        writer.close();
    }
}
