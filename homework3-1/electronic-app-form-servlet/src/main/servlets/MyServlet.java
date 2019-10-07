package main.servlets;

import main.Validation;

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

        writer.println("<style>table {border: 2px solid} td {border: 1px solid}</style>");
        writer.println("<table><tbody><tr><th>Name</th><th>Value</th></tr>");

        for (String param : parameterMap.keySet()) {
            for (String value : parameterMap.get(param)) {
                writer.println("<tr><td>" + param + "</td><td>" + value + "</td></tr>");
            }
        }
        writer.println("</tbody></table>");
        writer.close();
    }
}
