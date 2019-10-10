package com.stormnet.task31.servlet;

import com.stormnet.task31.util.Validation;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

@WebServlet("/result-servlet.html")
public class ResultServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        if (Validation.isInvalidation(request)) {
            RequestDispatcher dispatcher = request.getRequestDispatcher("/index.html");
            dispatcher.forward(request, response);
        }


        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();

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
        Enumeration<String> attributeNames = request.getAttributeNames();
        while (attributeNames.hasMoreElements()) {
            String attributeName = attributeNames.nextElement();
            if (attributeName.equals("other_course[]") || attributeName.equals("sources")) {
                for (String value : (String[]) request.getAttribute(attributeName)) {
                    writer.println("<tr><td>" + attributeName + "</td><td>" + value + "</td></tr>");
                }
                continue;
            }
            writer.println("<tr><td>" + attributeName + "</td><td>" + (String) request.getAttribute(attributeName) + "</td></tr>");
        }
        writer.println("</tbody>");
        writer.println("</table>");
        writer.println("</body>");
        writer.println("</html>");
        writer.close();
    }
}